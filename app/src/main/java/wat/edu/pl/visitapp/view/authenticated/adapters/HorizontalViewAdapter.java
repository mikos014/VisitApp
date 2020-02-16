package wat.edu.pl.visitapp.view.authenticated.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.view.authenticated.viewholders.HorizontalViewHolder;

public class HorizontalViewAdapter extends RecyclerView.Adapter<HorizontalViewHolder>
{

    private List<Doctor> doctorsList;

    public HorizontalViewAdapter(List<Doctor> doctorsList)
    {
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horizontal_recyclerview_items, parent, false);

        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position)
    {
        holder.getTvName().setText(doctorsList.get(position).getName());
        holder.getTvSpec().setText(doctorsList.get(position).getSpec());
        holder.getTvRating().setText(String.valueOf(doctorsList.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }
}
