package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.dialogs.CancellationAlertDialog;

public class VerticalCancellationHolder extends RecyclerView.ViewHolder {
    private TextView tvVisitDate;
    private TextView tvVisitTime;
    private TextView tvVisitDoctorName;
    private TextView tvVisitDoctorSpec;
    private TextView tvVisitDoctorRating;
    private TextView tvVisitDoctorDistance;
    private Button bCancelVisit;

    public VerticalCancellationHolder(@NonNull View view, List<Visit> list, int userId) {
        super(view);

        tvVisitDate = view.findViewById(R.id.tvCancellationVisitDate);
        tvVisitTime = view.findViewById(R.id.tvCancellationVisitTime);
        tvVisitDoctorName = view.findViewById(R.id.tvCancellationDoctorName);
        tvVisitDoctorSpec = view.findViewById(R.id.tvCancellationDoctorSpec);
        tvVisitDoctorRating = view.findViewById(R.id.tvCancellationDoctorRating);
        tvVisitDoctorDistance = view.findViewById(R.id.tvCancellationDoctorDistance);
        bCancelVisit = view.findViewById(R.id.bCancelVisit);

        bCancelVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putInt("visitId", getVisitId(list));
                args.putInt("userId", userId);
                CancellationAlertDialog dialog = new CancellationAlertDialog();
                FragmentManager fm = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
                dialog.setArguments(args);
                dialog.show(fm, "");
            }
        });
    }

    private int getVisitId(List<Visit> list) {
        return list.get(getAdapterPosition()).getVisitId();
    }

    public TextView getTvVisitDate() {
        return tvVisitDate;
    }

    public TextView getTvVisitTime() {
        return tvVisitTime;
    }

    public TextView getTvVisitDoctorName() {
        return tvVisitDoctorName;
    }

    public TextView getTvVisitDoctorSpec() {
        return tvVisitDoctorSpec;
    }

    public TextView getTvVisitDoctorRating() {
        return tvVisitDoctorRating;
    }

    public TextView getTvVisitDoctorDistance() {
        return tvVisitDoctorDistance;
    }

}
