package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.utils.ToastUtil;

public class VerticalPrescriptionHolder extends RecyclerView.ViewHolder
{
    private TextView tvNumber;
    private TextView tvIssuedBy;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private Button bMore;

    public VerticalPrescriptionHolder(final View view) {
        super(view);

        tvNumber = view.findViewById(R.id.tvPrescriptionNumber);
        tvIssuedBy = view.findViewById(R.id.tvPrescriptionIssuedBy);
        tvIssuedDate = view.findViewById(R.id.tvPrescriptionIssuedDate);
        tvExpirationDate = view.findViewById(R.id.tvPrescriptionExpiryDate);
        bMore = view.findViewById(R.id.bPreMore);

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

    public TextView getTvIssuedBy() {
        return tvIssuedBy;
    }

    public TextView getTvIssuedDate() {
        return tvIssuedDate;
    }

    public TextView getTvExpirationDate() {
        return tvExpirationDate;
    }

    public Button getbMore() {
        return bMore;
    }
}
