package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.utils.ToastUtil;

public class HorizontalViewHolder extends RecyclerView.ViewHolder
{
    private TextView tvName;
    private TextView tvSpec;
    private TextView tvRating;
    private Button bSelectDoctor;

    public HorizontalViewHolder(final View view)
    {
        super(view);

        tvName = view.findViewById(R.id.tvDoctorName);
        tvSpec = view.findViewById(R.id.tvDoctorSpec);
        tvRating = view.findViewById(R.id.tvDoctorRating);
        bSelectDoctor = view.findViewById(R.id.bSelectDoctor);

        bSelectDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast(view.getContext(), tvName.toString());
//                book();
            }
        });
    }

    public TextView getTvName() {
        return tvName;
    }

    public TextView getTvSpec() {
        return tvSpec;
    }

    public TextView getTvRating() {
        return tvRating;
    }

    public Button getbSelectDoctor() {
        return bSelectDoctor;
    }

}
