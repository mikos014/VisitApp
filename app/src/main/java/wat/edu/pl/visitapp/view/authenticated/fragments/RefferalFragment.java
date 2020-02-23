package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.RefferalConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.RefferalCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.VerticalRefferalAdapter;

public class RefferalFragment extends Fragment implements RefferalCallback
{
    private RecyclerView rvVerticalRefferal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_refferal, container, false);

        getActivity().setTitle(R.string.refferal);

        Bundle args = getArguments();
        User user = (User) args.getSerializable("user");

        rvVerticalRefferal = view.findViewById(R.id.rvVerticalRefferal);

        RefferalConnection connection = new RefferalConnection(this);

        rvVerticalRefferal.setHasFixedSize(true);

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.VERTICAL);
        rvVerticalRefferal.setAdapter(new VerticalRefferalAdapter(connection.getRefferalList(user)));
        rvVerticalRefferal.setLayoutManager(managerCardView);

        return view;
    }

    @Override
    public void onSuccess()
    {
        ToastUtil.shortToast(getActivity(), "Pobrano skierowania");
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(getActivity(), message);
    }
}
