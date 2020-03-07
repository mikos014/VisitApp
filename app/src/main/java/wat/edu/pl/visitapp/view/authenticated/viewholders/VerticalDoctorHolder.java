package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.activities.VisitDetailsActivity;

public class VerticalDoctorHolder extends RecyclerView.ViewHolder {

    private TextView tvDoctorName;
    private TextView tvDoctorSpec;
    private TextView tvDoctorRating;
    private TextView tvDoctorDistance;
    private Button bBookVisit;

    public VerticalDoctorHolder(@NonNull final View view, final List<Visit> list) {
        super(view);

        tvDoctorName = view.findViewById(R.id.tvSearchDoctorName);
        tvDoctorSpec = view.findViewById(R.id.tvSearchDoctorSpec);
        tvDoctorRating = view.findViewById(R.id.tvSearchDoctorRating);
        tvDoctorDistance = view.findViewById(R.id.tvSearchDoctorDistance);
        bBookVisit = view.findViewById(R.id.bSearchSelectDoctor);

        bBookVisit.setOnClickListener(v -> {
            Visit visit = getVisit(list, tvDoctorName.getText().toString());
            Intent detailActivity = new Intent(v.getContext(), VisitDetailsActivity.class);
            detailActivity.putExtra("visit", visit);
            view.getContext().startActivity(detailActivity);
            ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    private Visit getVisit(List<Visit> list, String doctorName)
    {
        for (Visit v: list)
        {
            if (v.getDoctor().getName().equals(doctorName))
                return v;
        }
        return null;
    }

    public TextView getTvDoctorName() {
        return tvDoctorName;
    }

    public TextView getTvDoctorSpec() {
        return tvDoctorSpec;
    }

    public TextView getTvDoctorRating() {
        return tvDoctorRating;
    }

    public TextView getTvDoctorDistance() {
        return tvDoctorDistance;
    }

}
