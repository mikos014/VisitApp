package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.callbacks.RightToBookCallback;
import wat.edu.pl.visitapp.database.connection.BrowseConnection;
import wat.edu.pl.visitapp.database.connection.RightToBookConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.activities.BrowseActivity;
import wat.edu.pl.visitapp.view.authenticated.activities.VisitDetailsActivity;
import wat.edu.pl.visitapp.view.authenticated.dialogs.ConfirmationErrorDialog;

public class VerticalBrowseHolder extends RecyclerView.ViewHolder implements RightToBookCallback {

    private View view;
    private TextView tvDoctorName;
    private TextView tvDoctorSpec;
    private TextView tvDoctorRating;
    private TextView tvDoctorDistance;
    private Button bBookVisit;

    private boolean hasRefferal;
    private List<Visit> list;
    private User user;

    public VerticalBrowseHolder(@NonNull final View view, final List<Visit> list, final User user) {
        super(view);

        this.view = view;
        this.list = list;
        this.user = user;

        tvDoctorName = view.findViewById(R.id.tvSearchDoctorName);
        tvDoctorSpec = view.findViewById(R.id.tvSearchDoctorSpec);
        tvDoctorRating = view.findViewById(R.id.tvSearchDoctorRating);
        tvDoctorDistance = view.findViewById(R.id.tvSearchDoctorDistance);
        bBookVisit = view.findViewById(R.id.bSearchSelectDoctor);

        RightToBookConnection connection = new RightToBookConnection(this);

        bBookVisit.setOnClickListener(v -> {
            if (tvDoctorSpec.getText().toString().equals("lekarz ogólny"))
                openVisitDetailsActivity();
            else
                connection.checkRightToBook(tvDoctorSpec.getText().toString(), user.getUserId());
        });
    }

    private Visit getVisit(List<Visit> list, String doctorName) {
        for (Visit v : list) {
            if (v.getDoctor().getName().equals(doctorName))
                return v;
        }
        return null;
    }

    private void openVisitDetailsActivity()
    {
        Visit visit = getVisit(list, tvDoctorName.getText().toString());
        Intent detailActivity = new Intent(view.getContext(), VisitDetailsActivity.class);
        detailActivity.putExtra("visit", visit);
        detailActivity.putExtra("user", user);
        view.getContext().startActivity(detailActivity);
        ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void showAlertDialog()
    {
        ConfirmationErrorDialog dialog = new ConfirmationErrorDialog();
        FragmentManager fm = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
        dialog.show(fm, "");
    }

    @Override
    public void onSuccessSetRightToBook(boolean hasRefferal) {
        if (hasRefferal)
            openVisitDetailsActivity();
        else
            showAlertDialog();
    }

    @Override
    public void onFailureSetRightToBook(String message) {
        ToastUtil.shortToast(view.getContext(), message);
    }

    @Override
    public Activity activity() {
        return (Activity)view.getContext();
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
