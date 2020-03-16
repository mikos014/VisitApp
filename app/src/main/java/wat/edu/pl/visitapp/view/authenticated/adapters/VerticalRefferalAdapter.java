package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.view.authenticated.viewholders.VerticalRefferalHolder;

public class VerticalRefferalAdapter extends RecyclerView.Adapter<VerticalRefferalHolder> {
    private List<Refferal> refferalList;

    public VerticalRefferalAdapter(List<Refferal> refferalList) {
        this.refferalList = refferalList;
    }

    @NonNull
    @Override
    public VerticalRefferalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.vertical_cardview_refferal, parent, false);

        return new VerticalRefferalHolder(view, refferalList);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRefferalHolder holder, int position) {
        holder.getTvNumber().setText(refferalList.get(position).getRefferalNo());
        holder.getTvIssuedBy().setText(refferalList.get(position).getIssuedByDoctor().getName());
        holder.getTvIssuedTo().setText(refferalList.get(position).getIssuedToDoctor());

        Date date = refferalList.get(position).getIssuedDate();
        Date datePlus30 = refferalList.get(position).getExpirationDate();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        holder.getTvIssuedDate().setText(sdf.format(date));
        holder.getTvExpirationDate().setText(sdf.format(datePlus30));
    }

    @Override
    public int getItemCount() {
        return refferalList.size();
    }
}
