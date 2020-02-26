package wat.edu.pl.visitapp.view.authenticated;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.MainCallback;
import wat.edu.pl.visitapp.view.authenticated.fragments.CancellationVisitFragment;
import wat.edu.pl.visitapp.view.authenticated.fragments.HistoryFragment;
import wat.edu.pl.visitapp.view.authenticated.fragments.PrescriptionFragment;
import wat.edu.pl.visitapp.view.authenticated.fragments.ProfileFragment;
import wat.edu.pl.visitapp.view.authenticated.fragments.RefferalFragment;
import wat.edu.pl.visitapp.view.authenticated.fragments.SearchFragment;
import wat.edu.pl.visitapp.view.welcome.LoginActivity;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainCallback
{
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TextView tvNavName, tvNavEmail;

    private User user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(toolbar);

        user = new User(1, "j.kowalski@wp.pl", "Jan", "Kowalski", "19800812", 0, "600000000");

        View headerView = navigationView.getHeaderView(0);
        tvNavName = headerView.findViewById(R.id.tvNavName);
        tvNavEmail = headerView.findViewById(R.id.tvNavEmail);
        tvNavName.setText(user.getName() + " " + user.getSurname());
        tvNavEmail.setText(user.getEmail());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_sideBar_open, R.string.navigation_sideBar_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Intent intent = getIntent();

        if(intent.getSerializableExtra("user") != null)
        {
            user = (User) intent.getSerializableExtra("user");
        }

        String action = (String) intent.getSerializableExtra("action");
        if (action != null)
        {
            if (action.equals(getString(R.string.historyOfVisits)))
            {
                openFragment(new HistoryFragment(), true);
            }
            else if (action.equals(getString(R.string.refferal)))
            {
                openFragment(new RefferalFragment(), true);
            }
            else if(action.equals(getString(R.string.prescription)))
            {
                openFragment(new PrescriptionFragment(), true);
            }
        }
        else
        {
            openFragment(new SearchFragment(), false);
        }
    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.nav_search:
                openFragment(new SearchFragment(), false);
                break;
            case R.id.nav_cancellation:
                openFragment(new CancellationVisitFragment(), true);
                break;
            case R.id.nav_history:
                openFragment(new HistoryFragment(), true);
                break;
            case R.id.nav_refferal:
                openFragment(new RefferalFragment(), true);
                break;
            case R.id.nav_prescription:
                openFragment(new PrescriptionFragment(), true);
                break;
            case R.id.nav_profile:
                openFragment(new ProfileFragment(), false);
                break;
            case R.id.nav_logout:
                Intent openMainActivity = new Intent(MainActivity.this, LoginActivity.class);
                openMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(openMainActivity);
                MainActivity.this.finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragment(Fragment fragment, boolean isUserNeeded)
    {
        if (isUserNeeded)
        {
            Bundle args = new Bundle();
            args.putSerializable("user", user);
            fragment.setArguments(args);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                fragment).commit();
    }

    @Override
    public Activity getActivity()
    {
        return MainActivity.this;
    }

}