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

import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.HistoryConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.HistoryCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.VerticalHistoryAdapter;

public class HistoryFragment extends Fragment implements HistoryCallback
{
    private RecyclerView rvHistory;
    private List<Visit> historyVisitList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        getActivity().setTitle(R.string.historyOfVisits);

        Bundle args = getArguments();
        User user = (User) args.getSerializable("user");

        rvHistory = view.findViewById(R.id.rvVerticalHistory);

        HistoryConnection connection = new HistoryConnection(this);
        connection.getHistoryVisit(user.getUserId());

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.VERTICAL);
        rvHistory.setAdapter(new VerticalHistoryAdapter(historyVisitList, user.getUserId()));
        rvHistory.setLayoutManager(managerCardView);

        return view;
    }

    @Override
    public void onSuccessSetHistoryList(List<Visit> historyList) {
        this.historyVisitList = historyList;
    }

    @Override
    public void onFailure(String message) {
        ToastUtil.shortToast(getActivity(), message);
    }
}
