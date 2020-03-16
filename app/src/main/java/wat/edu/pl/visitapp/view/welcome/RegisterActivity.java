package wat.edu.pl.visitapp.view.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.control.DataControl;
import wat.edu.pl.visitapp.database.connection.RegisterConnection;
import wat.edu.pl.visitapp.interfaces.callbacks.RegisterCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;

public class RegisterActivity extends AppCompatActivity implements RegisterCallback {
    private EditText etEmail, etPassword, etName, etSurname, etDateOfBirth, etPhoneNumber;
    private RadioGroup rgSex;
    private Button bConfirm;

    private DataControl dataControl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etDateOfBirth = findViewById(R.id.etDateOfBirth);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);

        rgSex = findViewById(R.id.rgSex);
        bConfirm = findViewById(R.id.bConfirm);

        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()
                        && !etName.getText().toString().isEmpty() && !etSurname.getText().toString().isEmpty()
                        && !etDateOfBirth.getText().toString().isEmpty() && !etPhoneNumber.getText().toString().isEmpty()
                        && etPassword.getText().toString().length() > 5) {
                    dataControl = new DataControl();
                    String email = etEmail.getText().toString();
                    String password = etPassword.getText().toString();
                    String name = etName.getText().toString();
                    String surname = etSurname.getText().toString();
                    String dateOfBirth = etDateOfBirth.getText().toString();
                    String phoneNumber = etPhoneNumber.getText().toString();
                    int sex = dataControl.getSex(rgSex, v.getRootView());

                    RegisterConnection rC = new RegisterConnection(RegisterActivity.this, email, password, name, surname, dateOfBirth, phoneNumber, sex);
                    rC.register();
                } else {
                    if (etEmail.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillEmail));
                    else if (etPassword.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillPassword));
                    else if (etName.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillName));
                    else if (etSurname.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillSurname));
                    else if (etDateOfBirth.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillDateOfBirth));
                    else if (etPhoneNumber.getText().toString().isEmpty())
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.fillPhoneNumber));
                    else if (etPassword.getText().toString().length() > 4)
                        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.passwordTooShort));
                }
            }
        });
    }

    void openLoginActivity() {
        Intent openLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(openLoginActivity);
        RegisterActivity.this.finish();
    }

    @Override
    public void onSuccess() {
        ToastUtil.shortToast(RegisterActivity.this, getString(R.string.registerSuccess));
        openLoginActivity();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(RegisterActivity.this, message);
    }

    @Override
    public Activity activity() {
        return RegisterActivity.this;
    }
}
