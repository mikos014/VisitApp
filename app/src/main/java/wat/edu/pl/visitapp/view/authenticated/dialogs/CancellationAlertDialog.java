package wat.edu.pl.visitapp.view.authenticated.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.CancelVisitConnection;
import wat.edu.pl.visitapp.database.callbacks.CancelVisitCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class CancellationAlertDialog extends DialogFragment implements CancelVisitCallback {
    private Button bYes;
    private Button bNo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_cancellation_alert, container, false);

        bYes = view.findViewById(R.id.bYes);
        bNo = view.findViewById(R.id.bNo);

        Bundle args = new Bundle();

        CancelVisitConnection connection = new CancelVisitConnection(this);

        bYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection.cancelTheVisit(args.getInt("visitId"), args.getInt("userId"));
            }
        });

        bNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    private void openMainActivity() {
        Intent mainActivity = new Intent(getContext(), MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainActivity);
    }

    @Override
    public void onSuccessCancel() {
        ToastUtil.shortToast(getContext(), getString(R.string.visitCancelled));

        openMainActivity();
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(getContext(), message);

    }

    @Override
    public Activity getFragment() {
        return getActivity();
    }
}
