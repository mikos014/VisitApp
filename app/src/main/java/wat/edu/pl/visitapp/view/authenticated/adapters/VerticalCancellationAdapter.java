package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.zip.Inflater;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.control.MapControl;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.viewholders.VerticalCancellationHolder;

public class VerticalCancellationAdapter extends RecyclerView.Adapter<VerticalCancellationHolder> {

    private List<Visit> list;

    public VerticalCancellationAdapter(List<Visit> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public VerticalCancellationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.vertical_cardview_visit_cancellation, parent, false);

        return new VerticalCancellationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalCancellationHolder holder, int position)
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        MapControl mapControl = new MapControl();
        String distance = mapControl.getDistance(list.get(position).getPlaceLatitude(), list.get(position).getPlaceLongitude());

        holder.getTvVisitDate().setText(sdf.format(list.get(position).getDate()));
        holder.getTvVisitTime().setText(list.get(position).getTime());
        holder.getTvVisitDoctorName().setText(list.get(position).getDoctor().getName());
        holder.getTvVisitDoctorSpec().setText(list.get(position).getDoctor().getSpec());
        holder.getTvVisitDoctorDistance().setText(distance);
        holder.getTvVisitDoctorRating().setText(String.valueOf(list.get(position).getDoctor().getRating()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
