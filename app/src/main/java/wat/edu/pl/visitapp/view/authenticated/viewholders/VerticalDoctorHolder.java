package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;

public class VerticalDoctorHolder extends RecyclerView.ViewHolder {

    private TextView tvDoctorName;
    private TextView tvDoctorSpec;
    private TextView tvDoctorRating;
    private Button bBookVisit;

    public VerticalDoctorHolder(@NonNull final View view) {
        super(view);

        tvDoctorName = view.findViewById(R.id.tvSearchDoctorName);
        tvDoctorSpec = view.findViewById(R.id.tvSearchDoctorSpec);
        tvDoctorRating = view.findViewById(R.id.tvSearchDoctorRating);
        bBookVisit = view.findViewById(R.id.bSearchSelectDoctor);

        bBookVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    public Button getbBookVisit() {
        return bBookVisit;
    }
}
