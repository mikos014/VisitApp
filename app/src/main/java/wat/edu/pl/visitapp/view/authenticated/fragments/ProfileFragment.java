package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.ProfileConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.ProfileCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class ProfileFragment extends Fragment implements ProfileCallback {
    private EditText etOldEmail;
    private EditText etNewEmail;
    private EditText etNewEmail2;
    private EditText etOldPassword;
    private EditText etNewPassword;
    private EditText etNewPassword2;
    private EditText etNewNumber;
    private Button bChangeEmail;
    private Button bChangePassword;
    private Button bChangeNumber;

    private User user;
    private ProfileConnection connection;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        etOldEmail = view.findViewById(R.id.etOldEmail);
        etNewEmail = view.findViewById(R.id.etNewEmail1);
        etNewEmail2 = view.findViewById(R.id.etNewEmail2);
        etOldPassword = view.findViewById(R.id.etOldPassword);
        etNewPassword = view.findViewById(R.id.etNewPassword1);
        etNewPassword2 = view.findViewById(R.id.etNewPassword2);
        etNewNumber = view.findViewById(R.id.etNumber);

        bChangeEmail = view.findViewById(R.id.bChangeEmail);
        bChangePassword = view.findViewById(R.id.bChangePassword);
        bChangeNumber = view.findViewById(R.id.bChangeNo);

        connection = new ProfileConnection(this);

        bChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNewEmail.getText().toString().equals("") && etNewEmail2.getText().toString().equals("")) {
                    ToastUtil.shortToast(getActivity(), getString(R.string.emailRequest));
                } else {
                    if (etNewEmail.getText().toString().equals(etNewEmail2.getText().toString())) {
                        connection.changeEmail(etOldEmail.getText().toString(), etNewEmail.getText().toString());
                    } else {
                        ToastUtil.shortToast(getContext(), getString(R.string.emailsAreDifferent));
                    }
                }
            }
        });

        bChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNewPassword.getText().toString().equals("") && etNewPassword2.getText().toString().equals("")) {
                    ToastUtil.shortToast(getActivity(), getString(R.string.passwordRequest));
                } else {
                    if (etNewPassword.getText().toString().equals(etNewPassword2.getText().toString())) {
                        connection.changePassword(etOldPassword.getText().toString(), etNewPassword.getText().toString());
                    } else {
                        ToastUtil.shortToast(getContext(), getString(R.string.passwordsAreDifferent));
                    }
                }
            }
        });

        bChangeNumber.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (etNewNumber.getText().toString().equals("")) {
                    ToastUtil.shortToast(getActivity(), getString(R.string.numberRequest));
                } else {
                    connection.changeNumber(etNewNumber.getText().toString());
                }
            }
        });
        return view;
    }

    private void openMainActivity() {
        Intent openMainActivity = new Intent(getActivity(), MainActivity.class);
        openMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        openMainActivity.putExtra("user", user);
        startActivity(openMainActivity);
    }

    @Override
    public void onSuccess(User user, String message) {
        this.user = user;
        ToastUtil.shortToast(getActivity(), getString(R.string.changeSaved) + message);
        openMainActivity();
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(getActivity(), message);
    }

    @Override
    public Activity getFragment() {
        return getActivity();
    }
}
