package wat.edu.pl.visitapp.view.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.LoginConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.callbacks.LoginCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginCallback {
    private EditText etEmail, etPassword;
    private Button bLogin, bRegister;

    private User user;
    private LoginConnection loginConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        if (intent != null) {
            user = (User) intent.getSerializableExtra("user");
        }

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        bLogin = findViewById(R.id.bLogin);
        bRegister = findViewById(R.id.bRegister);

//        do usunięcia
        etEmail.setText("kowalski@wp.pl");
        etPassword.setText("abc1234");
//

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
                    loginConnection = new LoginConnection(LoginActivity.this, etEmail.getText().toString(), etPassword.getText().toString());
                    loginConnection.login();
                } else {
                    if (etEmail.getText().toString().isEmpty())
                        ToastUtil.shortToast(LoginActivity.this, getString(R.string.emailRequest));
                    else
                        ToastUtil.shortToast(LoginActivity.this, getString(R.string.passwordRequest));
                }
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent closeApp = new Intent(Intent.ACTION_MAIN);
        closeApp.addCategory(Intent.CATEGORY_HOME);
        closeApp.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(closeApp);
    }

    private void openRegisterActivity() {
        Intent openRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(openRegisterActivity);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void openMainActivity() {
        Intent openMainActivity = new Intent(LoginActivity.this, MainActivity.class);
        openMainActivity.putExtra("user", user);
        startActivity(openMainActivity);
        LoginActivity.this.finish();
    }

    @Override
    public void onSuccess(User user) {
        this.user = user;
        ToastUtil.shortToast(LoginActivity.this, getString(R.string.logInSuccess));
        openMainActivity();
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(LoginActivity.this, message);
    }

    @Override
    public Activity activity() {
        return LoginActivity.this;
    }
}
