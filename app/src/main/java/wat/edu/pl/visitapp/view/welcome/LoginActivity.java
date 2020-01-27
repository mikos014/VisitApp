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
import wat.edu.pl.visitapp.interfaces.callbacks.LoginCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginCallback
{
    private EditText etEmail, etPassword;
    private Button bLogin, bRegister;

    private User user;
    private LoginConnection loginConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        bLogin = findViewById(R.id.bLogin);
        bRegister = findViewById(R.id.bRegister);

        bLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty())
                {
                    loginConnection = new LoginConnection(LoginActivity.this, etEmail.getText().toString(), etPassword.getText().toString(), user);
                    loginConnection.login();
                }
                else
                {
                    if (etEmail.getText().toString().isEmpty())
                        ToastUtil.shortToast(LoginActivity.this, getString(R.string.emailRequest));
                    else
                        ToastUtil.shortToast(LoginActivity.this, getString(R.string.passwordRequest));
                }
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openRegisterActivity();
            }
        });
    }

    private void openRegisterActivity()
    {
        Intent openRegisterActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(openRegisterActivity);
    }

    private void openMainActivity()
    {
        Intent openMainActivity = new Intent(LoginActivity.this, MainActivity.class);
        openMainActivity.putExtra("user", user);
        startActivity(openMainActivity);
        LoginActivity.this.finish();
    }

    @Override
    public void onSuccess(User user)
    {
        this.user = user;
        ToastUtil.shortToast(LoginActivity.this, getString(R.string.logInSuccess));
        openMainActivity();
    }

    @Override
    public void onFailure(String message)
    {
        ToastUtil.shortToast(LoginActivity.this, message);
    }

    @Override
    public Activity activity() {
        return LoginActivity.this;
    }
}
