package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.callbacks.RightToBookCallback;
import wat.edu.pl.visitapp.database.connection.RightToBookConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.activities.VisitDetailsActivity;
import wat.edu.pl.visitapp.view.authenticated.dialogs.ConfirmationErrorDialog;

public class HorizontalSearchHolder extends RecyclerView.ViewHolder implements RightToBookCallback {
    private TextView tvName;
    private TextView tvSpec;
    private TextView tvDistance;
    private TextView tvRating;
    private Button bSelectDoctor;

    private View view;
    private List<Visit> list;
    private User user;

    public HorizontalSearchHolder(final View view, final List<Visit> list, final User user) {
        super(view);

        this.view = view;
        this.list = list;
        this.user = user;

        tvName = view.findViewById(R.id.tvDoctorName);
        tvSpec = view.findViewById(R.id.tvDoctorSpec);
        tvDistance = view.findViewById(R.id.tvDoctorDistance);
        tvRating = view.findViewById(R.id.tvDoctorRating);
        bSelectDoctor = view.findViewById(R.id.bSelectDoctor);

        RightToBookConnection connection = new RightToBookConnection(this);
        bSelectDoctor.setOnClickListener(v -> {
            if (tvSpec.getText().toString().equals("lekarz ogólny"))
                openVisitDetailsActivity();
            else
                connection.checkRightToBook(tvSpec.getText().toString(), user.getUserId());
        });
    }

    private Visit getVisit(List<Visit> list, String doctorName) {
        for (Visit v : list) {
            if (v.getDoctor().getName().equals(doctorName))
                return v;
        }
        return null;
    }

    private void showAlertDialog()
    {
        ConfirmationErrorDialog dialog = new ConfirmationErrorDialog();
        FragmentManager fm = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
        dialog.show(fm, "");
    }

    private void openVisitDetailsActivity()
    {
        Visit visit = getVisit(list, tvName.getText().toString());
        Intent detailActivity = new Intent(view.getContext(), VisitDetailsActivity.class);
        detailActivity.putExtra("visit", visit);
        detailActivity.putExtra("user", user);
        view.getContext().startActivity(detailActivity);
        ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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
