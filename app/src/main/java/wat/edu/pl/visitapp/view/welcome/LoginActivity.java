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
import wat.edu.pl.visitapp.interfaces.callbacks.ConnectionCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;

public class LoginActivity extends AppCompatActivity implements ConnectionCallback
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
        bLogin.findViewById(R.id.bLogin);
        bLogin.findViewById(R.id.bPassword);

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

    }

    @Override
    public void onSuccess(User user)
    {
        this.user = user;
        openMainActivity();
    }

    @Override
    public void onFailure(String message)
    {

    }

    @Override
    public Activity activity() {
        return LoginActivity.this;
    }
}
