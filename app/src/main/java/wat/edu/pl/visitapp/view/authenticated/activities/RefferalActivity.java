package wat.edu.pl.visitapp.view.authenticated.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class RefferalActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_refferal);
    }

    @Override
    public void onBackPressed() {
        Intent openRefferalFragment = new Intent(RefferalActivity.this, MainActivity.class);
        openRefferalFragment.putExtra("action", getString(R.string.refferal));
        startActivity(openRefferalFragment);

        RefferalActivity.this.finish();
    }
}
