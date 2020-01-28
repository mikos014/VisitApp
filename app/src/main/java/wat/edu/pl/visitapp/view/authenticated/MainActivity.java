package wat.edu.pl.visitapp.view.authenticated;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;

public class MainActivity extends AppCompatActivity
{
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
    }
}
