package wat.edu.pl.visitapp.view.authenticated.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.BookingConnection;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.database.callbacks.BookingCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class ConfirmationDialog extends DialogFragment implements BookingCallback {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_confirmation, container, false);

        Bundle args = getArguments();
        BookingConnection connection = new BookingConnection(this);

        Visit visit = (Visit) args.getSerializable("visit");

        TextView tvDate = view.findViewById(R.id.tvDialogDate);
        TextView tvTime = view.findViewById(R.id.tvDialogTime);
        Button bYes = view.findViewById(R.id.bYes);
        Button bNo = view.findViewById(R.id.bNo);

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        tvDate.setText(sdf.format(visit.getDate()));
        tvTime.setText(visit.getTime());

        bYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connection.bookVisit(visit);
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
    public void onSuccessBooking() {
        ToastUtil.shortToast(getContext(), getString(R.string.visitBooked));

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
