package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.CancellationConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.CancellationCallback;
import wat.edu.pl.visitapp.view.authenticated.adapters.VerticalCancellationAdapter;

public class CancellationVisitFragment extends Fragment implements CancellationCallback
{
    private RecyclerView rvVerticalCancellation;
    private List<Visit> listOfVisit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cancellation_visit, container, false);
        getActivity().setTitle(R.string.cancelVisit);

        rvVerticalCancellation = view.findViewById(R.id.rvCancellationVisit);

        Bundle args = getArguments();
        User user = (User) args.getSerializable("user");

        CancellationConnection connection = new CancellationConnection(this);
        listOfVisit = connection.getCancellationVisits(user);

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.VERTICAL);
        rvVerticalCancellation.setAdapter(new VerticalCancellationAdapter(listOfVisit));
        rvVerticalCancellation.setLayoutManager(managerCardView);

        return view;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {

    }
}
