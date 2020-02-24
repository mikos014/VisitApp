package wat.edu.pl.visitapp.view.authenticated.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class PrescriptionActivity extends AppCompatActivity {
    private TextView tvNumber;
    private TextView tvUser;
    private TextView tvMedicineName1;
    private TextView tvMedicineForm1;
    private TextView tvMedicineDosage1;
    private TextView tvMedicineMethodOfDosage1;
    private TextView tvMedicineName2;
    private TextView tvMedicineForm2;
    private TextView tvMedicineDosage2;
    private TextView tvMedicineMethodOfDosage2;
    private TextView tvMedicineName3;
    private TextView tvMedicineForm3;
    private TextView tvMedicineDosage3;
    private TextView tvMedicineMethodOfDosage3;
    private TextView tvIssuedDate;
    private TextView tvExpirationDate;
    private TextView tvDoctorSpec;
    private TextView tvDoctor;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_prescription);

        tvNumber = findViewById(R.id.tvPreNo);
        tvUser = findViewById(R.id.tvPreUser);
        tvMedicineName1 = findViewById(R.id.tvMedicineName1);
        tvMedicineForm1 = findViewById(R.id.tvMedicineForm1);
        tvMedicineDosage1 = findViewById(R.id.tvMedicineDosage1);
        tvMedicineMethodOfDosage1 = findViewById(R.id.tvMedicineMethodOfDosage1);
        tvMedicineName2 = findViewById(R.id.tvMedicineName2);
        tvMedicineForm2 = findViewById(R.id.tvMedicineForm2);
        tvMedicineDosage2 = findViewById(R.id.tvMedicineDosage2);
        tvMedicineMethodOfDosage2 = findViewById(R.id.tvMedicineMethodOfDosage2);
        tvMedicineName3 = findViewById(R.id.tvMedicineName3);
        tvMedicineForm3 = findViewById(R.id.tvMedicineForm3);
        tvMedicineDosage3 = findViewById(R.id.tvMedicineDosage3);
        tvMedicineMethodOfDosage3 = findViewById(R.id.tvMedicineMethodOfDosage3);
        tvIssuedDate = findViewById(R.id.tvIssDate);
        tvExpirationDate = findViewById(R.id.tvExpDate);
        tvDoctorSpec = findViewById(R.id.tvPreDoctorSpec);
        tvDoctor = findViewById(R.id.tvPreDoctor);

        Bundle args = getIntent().getExtras();
        Prescription p;

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        p = (Prescription) args.getSerializable("prescription");
        if (p != null) {
            tvNumber.setText(p.getPrescriptionNo());
            String user = p.getIssuedToUser().getName() + " " + p.getIssuedToUser().getSurname();
            tvUser.setText(user);
            tvMedicineName1.setText(p.getMedicine().get(0).getName());
            tvMedicineForm1.setText(p.getMedicine().get(0).getForm());
            tvMedicineDosage1.setText(p.getMedicine().get(0).getDosage());
            tvMedicineMethodOfDosage1.setText(p.getMedicine().get(0).getMethodOfDosage());
            tvIssuedDate.setText(sdf.format(p.getIssuedDate()));
            tvExpirationDate.setText(sdf.format(p.getExpirationDate()));
            tvDoctorSpec.setText(p.getIssuedByDoctor().getSpec());
            tvDoctor.setText(p.getIssuedByDoctor().getName());


            if (p.getMedicine().size() > 1) {
                tvMedicineName2.setText(p.getMedicine().get(1).getName());
                tvMedicineForm2.setText(p.getMedicine().get(1).getForm());
                tvMedicineDosage2.setText(p.getMedicine().get(1).getDosage());
                tvMedicineMethodOfDosage2.setText(p.getMedicine().get(1).getMethodOfDosage());
            }
            if (p.getMedicine().size() > 2) {
                tvMedicineName3.setText(p.getMedicine().get(2).getName());
                tvMedicineForm3.setText(p.getMedicine().get(2).getForm());
                tvMedicineDosage3.setText(p.getMedicine().get(2).getDosage());
                tvMedicineMethodOfDosage3.setText(p.getMedicine().get(2).getMethodOfDosage());
            }
        }
    }

    @Override
    public void onBackPressed() {
        PrescriptionActivity.this.finish();
        Intent openPrescriptionFragment = new Intent(PrescriptionActivity.this, MainActivity.class);
//        openPrescriptionFragment.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        openPrescriptionFragment.putExtra("action", getString(R.string.prescription));
        startActivity(openPrescriptionFragment);

        PrescriptionActivity.this.finish();
    }
}
