package wat.edu.pl.visitapp.view.authenticated.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.BrowseConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.VeriticalDoctorAdapter;

public class BrowseActivity extends AppCompatActivity implements SearchCallback
{
    private Toolbar tSearch;
    private RecyclerView rvList;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        Intent intent = getIntent();

        user = (User) intent.getSerializableExtra("user");
        String queryText = (String) intent.getSerializableExtra("query");

        setTitle(getString(R.string.singleQuotationMark) + queryText + getString(R.string.singleQuotationMark));
        tSearch = findViewById(R.id.searchToolbar);
        rvList = findViewById(R.id.rvList);

        setSupportActionBar(tSearch);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BrowseConnection connection = new BrowseConnection(BrowseActivity.this);
        List<Visit> list = connection.getVisitsLimitByString(queryText);

        LinearLayoutManager managerCardView = new LinearLayoutManager(BrowseActivity.this);
        rvList.setAdapter(new VeriticalDoctorAdapter(list));
        rvList.setLayoutManager(managerCardView);
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
        ToastUtil.shortToast(BrowseActivity.this, message);
    }

    @Override
    public Activity getFragment() {
        return null;
    }
}
