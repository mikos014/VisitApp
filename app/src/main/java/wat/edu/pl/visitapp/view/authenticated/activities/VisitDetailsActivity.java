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
import wat.edu.pl.visitapp.database.connection.SearchConnection;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.ExpandableDatesAdapter;

public class VisitDetailsActivity extends AppCompatActivity implements SearchCallback
{
    private Toolbar toolbar;
    private TextView tvDoctorName;
    private TextView tvDoctorSpec;
    private TextView tvDoctorRating;
    private TextView tvClinicName;
    private TextView tvClinicStreet;
    private TextView tvClinicCity;
    private TextView tvClinicPhoneNo;
    private ExpandableListView elvDatesOfVisits;

    private HashMap<String, List<String>> itemsMap;

    private Visit visit;

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

        tvDoctorName.setText(visit.getDoctor().getName());
        tvDoctorSpec.setText(visit.getDoctor().getSpec());
        tvDoctorRating.setText(String.valueOf(visit.getDoctor().getRating()));
        tvClinicName.setText(visit.getClinicName());
        tvClinicStreet.setText(visit.getClinicStreet());
        tvClinicCity.setText(visit.getClinicCity());
        tvClinicPhoneNo.setText(visit.getClinicPhoneNo());

        SearchConnection connection = new SearchConnection(VisitDetailsActivity.this);
        itemsMap = connection.getDatesOfVisits(visit.getVisitId());

        ExpandableDatesAdapter adapter = new ExpandableDatesAdapter(VisitDetailsActivity.this, getHeaders(itemsMap), itemsMap);
        elvDatesOfVisits.setAdapter(adapter);

    }

    private List<String> getHeaders(HashMap<String, List<String>> hashMap) {
        final List<String> list = new LinkedList<>();
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
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(VisitDetailsActivity.this, message);
    }

    @Override
    public Activity getFragment() {
        return VisitDetailsActivity.this;
    }
}
