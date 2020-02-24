package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Ref;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;
import wat.edu.pl.visitapp.view.authenticated.activities.RefferalActivity;

public class VerticalRefferalHolder extends RecyclerView.ViewHolder
{
    private TextView tvNumber;
    private TextView tvIssuedTo;
    private TextView tvIssuedBy;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private Button bMore;

    public VerticalRefferalHolder(@NonNull final View view, final List<Refferal> list) {
        super(view);

        tvNumber = view.findViewById(R.id.tvRefferalNumber);
        tvIssuedTo = view.findViewById(R.id.tvRefferalIssuedTo);
        tvIssuedBy = view.findViewById(R.id.tvRefferalIssuedBy);
        tvIssuedDate = view.findViewById(R.id.tvRefferalIssuedDate);
        tvExpirationDate = view.findViewById(R.id.tvRefferalExpiryDate);
        bMore = view.findViewById(R.id.bRefMore);

        bMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast(view.getContext(), "Więcej...");

                Refferal refferal = getRefferal(list, tvNumber.getText().toString());

                Intent openRefferalActivity = new Intent(view.getContext(), RefferalActivity.class);
                openRefferalActivity.putExtra("refferal", refferal);
                v.getContext().startActivity(openRefferalActivity);
                ((Activity) v.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private Refferal getRefferal(List<Refferal> refferals, String refferalNo)
    {
        for (Refferal r: refferals) {
            if (r.getRefferalNo().equals(refferalNo))
                return r;
        }
        return null;
    }

    public TextView getTvNumber() {
        return tvNumber;
    }

    public TextView getTvIssuedTo() {
        return tvIssuedTo;
    }

    public TextView getTvIssuedBy() {
        return tvIssuedBy;
    }

    public TextView getTvIssuedDate() {
        return tvIssuedDate;
    }

    public TextView getTvExpirationDate() {
        return tvExpirationDate;
    }
}
