package wat.edu.pl.visitapp.view.authenticated.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.VisitDetailConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.VisitDetailCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.ExpandableDatesAdapter;

public class VisitDetailsActivity extends AppCompatActivity implements VisitDetailCallback {
    private Toolbar toolbar;
    private TextView tvDoctorName;
    private TextView tvDoctorSpec;
    private TextView tvDoctorRating;
    private TextView tvClinicName;
    private TextView tvClinicStreet;
    private TextView tvClinicCity;
    private TextView tvClinicPhoneNo;
    private ExpandableListView elvDatesOfVisits;

    private HashMap itemsMap;

    private boolean hasRefferal;
    private Visit visit;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_visit_detail);

        toolbar = findViewById(R.id.detailToolbar);
        tvDoctorName = findViewById(R.id.tvDetailDoctorName);
        tvDoctorSpec = findViewById(R.id.tvDetailDoctorSpec);
        tvDoctorRating = findViewById(R.id.tvDetailDoctorRating);
        tvClinicName = findViewById(R.id.tvDetailClinicName);
        tvClinicStreet = findViewById(R.id.tvDetailClinicStreet);
        tvClinicCity = findViewById(R.id.tvDetailClinicCity);
        tvClinicPhoneNo = findViewById(R.id.tvDetailClinicNo);
        elvDatesOfVisits = findViewById(R.id.elvDatesOfVisits);

        setTitle(R.string.chooseDateOfVisit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();

        visit = (Visit) intent.getSerializableExtra("visit");
        user = (User) intent.getSerializableExtra("user");

        tvDoctorName.setText(visit.getDoctor().getName());
        tvDoctorSpec.setText(visit.getDoctor().getSpec());
        tvDoctorRating.setText(String.valueOf(visit.getDoctor().getRating()));
        tvClinicName.setText(visit.getClinicName());
        tvClinicStreet.setText(visit.getClinicStreet());
        tvClinicCity.setText(visit.getClinicCity());
        tvClinicPhoneNo.setText(visit.getClinicPhoneNo());

        VisitDetailConnection connection = new VisitDetailConnection(this);
        connection.getDatesOfVisits(visit.getVisitId());
        connection.checkRightToBook(visit.getVisitId(), user.getUserId());

        ExpandableDatesAdapter adapter = new ExpandableDatesAdapter(VisitDetailsActivity.this, getHeaders(itemsMap), itemsMap, hasRefferal, visit);
        elvDatesOfVisits.setAdapter(adapter);
    }

    private List<String> getHeaders(HashMap<String, List<String>> hashMap) {
        final List<String> list = new LinkedList<>();

        if(hashMap.size() > 0)
            hashMap.forEach((k, v) -> list.add(k));
        return list;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onSuccessSetDates(HashMap hashMap) {
        itemsMap = hashMap;
    }

    @Override
    public void onSuccessSetRightToBook(boolean hasRefferal) {
        this.hasRefferal = hasRefferal;
    }

    @Override
    public void onFailureSetDates(String message) {
        ToastUtil.shortToast(VisitDetailsActivity.this, message);
        itemsMap = new HashMap();
    }

    @Override
    public void onFailureSetRightToBook(String message) {
        ToastUtil.shortToast(VisitDetailsActivity.this, message);
        hasRefferal = false;
    }

    @Override
    public Activity activity() {
        return VisitDetailsActivity.this;
    }
}
