package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.activities.PrescriptionActivity;

public class VerticalPrescriptionHolder extends RecyclerView.ViewHolder
{
    private TextView tvNumber;
    private TextView tvIssuedBy;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private Button bMore;

    public VerticalPrescriptionHolder(final View view, final List<Prescription> list) {
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

                Prescription prescription = getPrescription(list, tvNumber.getText().toString());

                Intent openPrescriptionActivity = new Intent(view.getContext(), PrescriptionActivity.class);
                openPrescriptionActivity.putExtra("prescription", prescription);
                v.getContext().startActivity(openPrescriptionActivity);
            }
        });
    }

    private Prescription getPrescription(List<Prescription> list, String prescriptionNo)
    {
        for (Prescription p: list)
        {
            if (p.getPrescriptionNo().equals(prescriptionNo))
                return p;
        }
        return null;
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
