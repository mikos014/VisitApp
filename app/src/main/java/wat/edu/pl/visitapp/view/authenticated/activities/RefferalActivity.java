package wat.edu.pl.visitapp.view.authenticated.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class RefferalActivity extends AppCompatActivity
{
    private TextView tvRefferalNo;
    private TextView tvUser;
    private TextView tvRefferalToDoctorSpec;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private TextView tvIssuedByDoctorSpec;
    private TextView tvIssuedByDoctor;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_refferal);

        tvRefferalNo = findViewById(R.id.tvRefNo);
        tvUser = findViewById(R.id.tvRefUser);
        tvRefferalToDoctorSpec = findViewById(R.id.tvRefDoctorSpec);
        tvIssuedDate = findViewById(R.id.tvRefIssDate);
        tvExpirationDate = findViewById(R.id.tvRefExpDate);
        tvIssuedByDoctorSpec = findViewById(R.id.tvRefIssuedByDoctorSpec);
        tvIssuedByDoctor = findViewById(R.id.tvRefIssuedByDoctor);

        Bundle args = getIntent().getExtras();
        Refferal r;

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        r = (Refferal) args.getSerializable("refferal");

        if (r != null)
        {
            tvRefferalNo.setText(r.getRefferalNo());
            tvUser.setText(r.getIssuedToUser().getName() + " " + r.getIssuedToUser().getSurname());
            tvRefferalToDoctorSpec.setText(r.getIssuedToDoctor());
            tvIssuedDate.setText(sdf.format(r.getIssuedDate()));
            tvExpirationDate.setText(sdf.format(r.getExpirationDate()));
            tvIssuedByDoctorSpec.setText(r.getIssuedByDoctor().getSpec());
            tvIssuedByDoctor.setText(r.getIssuedByDoctor().getName());
        }
    }

    @Override
    public void onBackPressed() {
        Intent openRefferalFragment = new Intent(RefferalActivity.this, MainActivity.class);
        openRefferalFragment.putExtra("action", getString(R.string.refferal));
        startActivity(openRefferalFragment);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        RefferalActivity.this.finish();
    }
}
