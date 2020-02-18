package wat.edu.pl.visitapp.view.authenticated;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

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
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if(intent != null)
        {
            user = (User) intent.getSerializableExtra("user");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_sideBar_open, R.string.navigation_sideBar_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SearchFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_search);
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SearchFragment()).commit();
                break;
            case R.id.nav_cancellation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CancellationVisitFragment()).commit();
                break;
            case R.id.nav_history:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HistoryFragment()).commit();
                break;
            case R.id.nav_refferal:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RefferalFragment()).commit();
                break;
            case R.id.nav_prescription:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PrescriptionFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_logout:
                Intent openMainActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(openMainActivity);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Activity getActivity()
    {
        return MainActivity.this;
    }

}