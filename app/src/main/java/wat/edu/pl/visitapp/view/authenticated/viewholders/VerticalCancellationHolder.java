package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.dialogs.CancellationAlertDialog;

public class VerticalCancellationHolder extends RecyclerView.ViewHolder
{
    private TextView tvVisitDate;
    private TextView tvVisitTime;
    private TextView tvVisitDoctorName;
    private TextView tvVisitDoctorSpec;
    private TextView tvVisitDoctorRating;
    private Button bCancelVisit;

    public VerticalCancellationHolder(@NonNull View view) {
        super(view);

        tvVisitDate = view.findViewById(R.id.tvCancellationVisitDate);
        tvVisitTime = view.findViewById(R.id.tvCancellationVisitTime);
        tvVisitDoctorName = view.findViewById(R.id.tvCancellationDoctorName);
        tvVisitDoctorSpec = view.findViewById(R.id.tvCancellationDoctorSpec);
        tvVisitDoctorRating = view.findViewById(R.id.tvCancellationDoctorRating);
        bCancelVisit = view.findViewById(R.id.bCancelVisit);

        bCancelVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CancellationAlertDialog dialog = new CancellationAlertDialog();
                FragmentManager fm = ((AppCompatActivity)v.getContext()).getSupportFragmentManager();
                dialog.show(fm, "");

                ToastUtil.shortToast(v.getContext(), String.valueOf(getAdapterPosition()));
            }
        });
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

    public Button getbCancelVisit() {
        return bCancelVisit;
    }
}
