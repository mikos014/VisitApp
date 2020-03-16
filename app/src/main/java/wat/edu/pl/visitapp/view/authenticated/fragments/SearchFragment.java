package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.SearchConnection;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.activities.BrowseActivity;
import wat.edu.pl.visitapp.view.authenticated.adapters.HorizontalSearchAdapter;

public class SearchFragment extends Fragment implements SearchCallback {
    private SearchView svSearch;
    private RecyclerView rvHorizontalDoctors;
    private ListView lvList;

    private List<Visit> visitAds;
    private List<String> specAds;
    private User user;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        getActivity().setTitle(R.string.search);

        Bundle args = getArguments();

        user = (User) args.getSerializable("user");

        svSearch = view.findViewById(R.id.svSearch);
        rvHorizontalDoctors = view.findViewById(R.id.rvHorizontalDoctors);
        lvList = view.findViewById(R.id.lvList);

        SearchConnection connection = new SearchConnection(this);
        connection.getExampleOfVisits();
        connection.getExampleOfSpecs();

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent openBrowseActivity = new Intent(getContext(), BrowseActivity.class);
                openBrowseActivity.putExtra("query", query);
                openBrowseActivity.putExtra("user", user);
                startActivity(openBrowseActivity);
                ((Activity) view.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.HORIZONTAL);
        rvHorizontalDoctors.setHasFixedSize(true);
        rvHorizontalDoctors.setAdapter(new HorizontalSearchAdapter(visitAds, user));
        rvHorizontalDoctors.setLayoutManager(managerCardView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_doctors_spec, specAds);
        lvList.setAdapter(arrayAdapter);

        lvList.setOnItemClickListener((parent, view1, position, id) -> {
            ToastUtil.shortToast(getContext(), parent.getItemAtPosition(position).toString());

            Intent browseActivity = new Intent(getContext(), BrowseActivity.class);
            browseActivity.putExtra("query", parent.getItemAtPosition(position).toString());
            browseActivity.putExtra("user", user);
            startActivity(browseActivity);
            ((Activity) view1.getContext()).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

//        MapControl mC = new MapControl();
//        ToastUtil.shortToast(getContext(), mC.getRouteDistance(51.421882, 21.924779, 51.424463, 21.951240));

        return view;
    }


    @Override
    public void onSuccessSetVisitAds(List<Visit> visitList) {
        visitAds = visitList;
    }

    @Override
    public void onSuccessSetDoctorSpecAds(List<String> specList) {
        specAds = specList;
    }

    @Override
    public void onFailureSetVisitAds(String message) {
        ToastUtil.shortToast(getContext(), message);
        visitAds = new LinkedList<>();
    }

    @Override
    public void onFailureSetDoctorSpecAds(String message) {
        ToastUtil.shortToast(getContext(), message);
        specAds = new LinkedList<>();
    }

    @Override
    public Activity getFragment() {
        return getActivity();
    }
}
