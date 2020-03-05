package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.control.MapControl;
import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.viewholders.HorizontalDoctorHolder;

public class HorizontalDoctorAdapter extends RecyclerView.Adapter<HorizontalDoctorHolder>
{
    private List<Visit> visitList;

    public HorizontalDoctorAdapter(List<Visit> visitList)
    {
        this.visitList = visitList;
    }

    @NonNull
    @Override
    public HorizontalDoctorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.horizontal_cardview_doctor, parent, false);

        return new HorizontalDoctorHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalDoctorHolder holder, int position)
    {
        MapControl mapControl = new MapControl();
        String distance = mapControl.getDistance(visitList.get(position).getPlaceLatitude(), visitList.get(position).getPlaceLongitude());

        holder.getTvName().setText(visitList.get(position).getDoctor().getName());
        holder.getTvSpec().setText(visitList.get(position).getDoctor().getSpec());
        holder.getTvDistance().setText(distance);
        holder.getTvRating().setText(String.valueOf(visitList.get(position).getDoctor().getRating()));
    }

    @Override
    public int getItemCount() {
        return visitList.size();
    }
}
