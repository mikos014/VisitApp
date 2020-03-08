package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.control.MapControl;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.viewholders.VerticalBrowseHolder;

public class VerticalBrowseAdapter extends RecyclerView.Adapter<VerticalBrowseHolder> {

    private List<Visit> visitList;
    private User user;

    public VerticalBrowseAdapter(List<Visit> visitList, User user) {
        this.visitList = visitList;
        this.user = user;
    }

    @NonNull
    @Override
    public VerticalBrowseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.vertical_cardview_doctor, parent, false);

        return new VerticalBrowseHolder(view, visitList, user);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalBrowseHolder holder, int position) {
        MapControl mapControl = new MapControl();
        String distance = mapControl.getDistance(visitList.get(position).getPlaceLatitude(), visitList.get(position).getPlaceLongitude());

        holder.getTvDoctorName().setText(visitList.get(position).getDoctor().getName());
        holder.getTvDoctorSpec().setText(visitList.get(position).getDoctor().getSpec());
        holder.getTvDoctorDistance().setText(distance);
        holder.getTvDoctorRating().setText(String.valueOf(visitList.get(position).getDoctor().getRating()));

    }

    @Override
    public int getItemCount() {
        return visitList.size();
    }
}
