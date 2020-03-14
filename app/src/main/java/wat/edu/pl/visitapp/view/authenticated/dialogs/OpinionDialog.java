package wat.edu.pl.visitapp.view.authenticated.dialogs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.OpinionConnection;
import wat.edu.pl.visitapp.interfaces.callbacks.OpinionCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.MainActivity;

public class OpinionDialog extends DialogFragment implements OpinionCallback
{
    private RatingBar rbDoctorRating;
    private TextView tvRatingDescription;
    private Button bSave;
    private Button bCancel;
    private int numberOfStars;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_opinion, container, false);

        OpinionConnection connection = new OpinionConnection(this);

        Bundle args = new Bundle();

        rbDoctorRating = view.findViewById(R.id.rbDoctorRating);
        tvRatingDescription = view.findViewById(R.id.tvRatingDescription);
        bSave = view.findViewById(R.id.bSave);
        bCancel = view.findViewById(R.id.bCancel);

        rbDoctorRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
            {
                switch ((int) ratingBar.getRating())
                {
                    case 1:
                        numberOfStars = 1;
                        tvRatingDescription.setText(R.string.veryBad);
                        break;
                    case 2:
                        numberOfStars = 2;
                        tvRatingDescription.setText(R.string.needSomeImprovements);
                        break;
                    case 3:
                        numberOfStars = 3;
                        tvRatingDescription.setText(R.string.average);
                        break;
                    case 4:
                        numberOfStars = 4;
                        tvRatingDescription.setText(R.string.good);
                        break;
                    case 5:
                        numberOfStars = 5;
                        tvRatingDescription.setText(R.string.excellent);
                        break;
                    default:
                        tvRatingDescription.setText("");
                }
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = tvRatingDescription.getText().toString();

                if (text.equals(""))
                {
                    ToastUtil.shortToast(getActivity(), getString(R.string.fillRatingStars));
                }
                else
                {
                    connection.addOpinion(args.getInt("visitId"), args.getInt("userId"), numberOfStars);
                }
            }
        });

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    private void openMainActivity()
    {
        Intent mainActivity = new Intent(getContext(), MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainActivity);
    }

    @Override
    public void onSuccessAddOpinion() {
        ToastUtil.shortToast(getContext(), getString(R.string.opinionAdded));

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
