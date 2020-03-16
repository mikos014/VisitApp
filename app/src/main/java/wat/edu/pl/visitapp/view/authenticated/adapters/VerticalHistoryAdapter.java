package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.viewholders.VerticalHistoryHolder;

public class VerticalHistoryAdapter extends RecyclerView.Adapter<VerticalHistoryHolder> {

    private List<Visit> historyVisitList;
    private int userId;

    public VerticalHistoryAdapter(List<Visit> historyVisitList, int userId) {
        this.historyVisitList = historyVisitList;
        this.userId = userId;
    }

    @NonNull
    @Override
    public VerticalHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_cardview_visit, parent, false);

        return new VerticalHistoryHolder(view, historyVisitList, userId);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalHistoryHolder holder, int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        holder.getTvHistoryVisitDate().setText(sdf.format(historyVisitList.get(position).getDate()));
        holder.getTvHistoryVisitTime().setText(historyVisitList.get(position).getTime());
        holder.getTvHistoryDoctorName().setText(historyVisitList.get(position).getDoctor().getName());
        holder.getTvHistoryDoctorSpec().setText(historyVisitList.get(position).getDoctor().getSpec());
        holder.getTvHistoryDoctorRating().setText(String.valueOf(historyVisitList.get(position).getDoctor().getRating()));

        if (historyVisitList.get(position).isHasOpinion()) {
            holder.getbAddOpinion().setVisibility(View.GONE);
        } else {
            holder.getbAddOpinion().setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return historyVisitList.size();
    }
}
