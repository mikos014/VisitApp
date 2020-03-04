package wat.edu.pl.visitapp.view.authenticated.viewholders;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.activities.BrowseActivity;

public class HorizontalDoctorHolder extends RecyclerView.ViewHolder
{
    private TextView tvName;
    private TextView tvSpec;
    private TextView tvRating;
    private Button bSelectDoctor;

    public HorizontalDoctorHolder(final View view)
    {
        super(view);

        tvName = view.findViewById(R.id.tvDoctorName);
        tvSpec = view.findViewById(R.id.tvDoctorSpec);
        tvRating = view.findViewById(R.id.tvDoctorRating);
        bSelectDoctor = view.findViewById(R.id.bSelectDoctor);

        bSelectDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.shortToast(view.getContext(), tvName.getText().toString());
                System.out.println(tvName.getText().toString());
                Intent openBrowseActivity = new Intent(v.getContext(), BrowseActivity.class);

//                do przekierowania na activity rezerwacji
                openBrowseActivity.putExtra("query", "abc");
                v.getContext().startActivity(openBrowseActivity);
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
}
