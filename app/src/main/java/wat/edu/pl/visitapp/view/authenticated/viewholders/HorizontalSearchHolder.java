package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.view.authenticated.activities.VisitDetailsActivity;

public class HorizontalSearchHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvSpec;
    private TextView tvDistance;
    private TextView tvRating;
    private Button bSelectDoctor;

    public HorizontalSearchHolder(final View view, final List<Visit> list, final User user) {
        super(view);

        tvName = view.findViewById(R.id.tvDoctorName);
        tvSpec = view.findViewById(R.id.tvDoctorSpec);
        tvDistance = view.findViewById(R.id.tvDoctorDistance);
        tvRating = view.findViewById(R.id.tvDoctorRating);
        bSelectDoctor = view.findViewById(R.id.bSelectDoctor);

        bSelectDoctor.setOnClickListener(v -> {
            Visit visit = getVisit(list, tvName.getText().toString());
            Intent detailActivity = new Intent(v.getContext(), VisitDetailsActivity.class);
            detailActivity.putExtra("visit", visit);
            detailActivity.putExtra("user", user);
            v.getContext().startActivity(detailActivity);
            ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    private Visit getVisit(List<Visit> list, String doctorName) {
        for (Visit v : list) {
            if (v.getDoctor().getName().equals(doctorName))
                return v;
        }
        return null;
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvSpec() {
        return tvSpec;
    }

    public TextView getTvDistance() {
        return tvDistance;
    }

    public TextView getTvRating() {
        return tvRating;
    }
}
