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
import wat.edu.pl.visitapp.view.authenticated.dialogs.OpinionDialog;

public class VerticalHistoryHolder extends RecyclerView.ViewHolder {
    private TextView tvHistoryVisitDate;
    private TextView tvHistoryVisitTime;
    private TextView tvHistoryDoctorName;
    private TextView tvHistoryDoctorSpec;
    private TextView tvHistoryDoctorRating;
    private Button bAddOpinion;

    public VerticalHistoryHolder(@NonNull final View view, final List<Visit> historyVisitList, final int userId) {
        super(view);

        tvHistoryVisitDate = view.findViewById(R.id.tvHistoryVisitDate);
        tvHistoryVisitTime = view.findViewById(R.id.tvHistoryVisitTime);
        tvHistoryDoctorName = view.findViewById(R.id.tvHistoryDoctorName);
        tvHistoryDoctorSpec = view.findViewById(R.id.tvHistoryDoctorSpec);
        tvHistoryDoctorRating = view.findViewById(R.id.tvHistoryDoctorRating);
        bAddOpinion = view.findViewById(R.id.bAddOpinion);

        bAddOpinion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putInt("visitId", getVisitId(historyVisitList));
                args.putInt("userId", userId);
                OpinionDialog dialog = new OpinionDialog();
                FragmentManager fm = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
                dialog.setArguments(args);
                dialog.show(fm, "");
            }
        });
    }

    private int getVisitId(List<Visit> historyList) {
        return historyList.get(getAdapterPosition()).getVisitId();
    }

    public TextView getTvHistoryVisitDate() {
        return tvHistoryVisitDate;
    }

    public TextView getTvHistoryVisitTime() {
        return tvHistoryVisitTime;
    }

    public TextView getTvHistoryDoctorName() {
        return tvHistoryDoctorName;
    }

    public TextView getTvHistoryDoctorSpec() {
        return tvHistoryDoctorSpec;
    }

    public TextView getTvHistoryDoctorRating() {
        return tvHistoryDoctorRating;
    }

    public Button getbAddOpinion() {
        return bAddOpinion;
    }
}
