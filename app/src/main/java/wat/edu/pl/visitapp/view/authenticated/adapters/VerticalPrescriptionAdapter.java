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
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.view.authenticated.viewholders.VerticalPrescriptionHolder;

public class VerticalPrescriptionAdapter extends RecyclerView.Adapter<VerticalPrescriptionHolder> {
    private List<Prescription> listOfPrescription;

    public VerticalPrescriptionAdapter(List<Prescription> listOfPrescription) {
        this.listOfPrescription = listOfPrescription;
    }

    @NonNull
    @Override
    public VerticalPrescriptionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.vertical_cardview_prescription, parent, false);

        return new VerticalPrescriptionHolder(view, listOfPrescription);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalPrescriptionHolder holder, int position) {
        holder.getTvNumber().setText(listOfPrescription.get(position).getPrescriptionNo());
        holder.getTvIssuedBy().setText(listOfPrescription.get(position).getIssuedByDoctor().getName());

        Date date = listOfPrescription.get(position).getIssuedDate();
        Date datePlus30 = listOfPrescription.get(position).getExpirationDate();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        holder.getTvIssuedDate().setText(sdf.format(date));
        holder.getTvExpirationDate().setText(sdf.format(datePlus30));
    }

    @Override
    public int getItemCount() {
        return listOfPrescription.size();
    }
}
