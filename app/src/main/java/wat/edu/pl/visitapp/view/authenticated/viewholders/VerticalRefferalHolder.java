package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.utils.ToastUtil;

public class VerticalRefferalHolder extends RecyclerView.ViewHolder
{
    private TextView tvNumber;
    private TextView tvIssuedTo;
    private TextView tvIssuedBy;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private Button bMore;

    public VerticalRefferalHolder(@NonNull final View view) {
        super(view);

        tvNumber = view.findViewById(R.id.tvRefferalNumber);
        tvIssuedTo = view.findViewById(R.id.tvRefferalIssuedTo);
        tvIssuedBy = view.findViewById(R.id.tvRefferalIssuedBy);
        tvIssuedDate = view.findViewById(R.id.tvRefferalIssuedDate);
        tvExpirationDate = view.findViewById(R.id.tvRefferalExpiryDate);
        bMore = view.findViewById(R.id.bMore);

        bMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast(view.getContext(), "Więcej...");
            }
        });
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
