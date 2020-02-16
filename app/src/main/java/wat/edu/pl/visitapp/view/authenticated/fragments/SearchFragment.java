package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.SearchConnection;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.HorizontalViewAdapter;

public class SearchFragment extends Fragment implements SearchCallback {
    private SearchConnection searchConnection;

    private SearchView svSearch;
    private RecyclerView rvCardView;
    private ListView lvList;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        svSearch = view.findViewById(R.id.svSearch);
        rvCardView = view.findViewById(R.id.horizontalCardView);
        lvList = view.findViewById(R.id.lvList);

        searchConnection = new SearchConnection(this);

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                search();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        rvCardView.setHasFixedSize(true);

        LinearLayoutManager managerCardView = new LinearLayoutManager(getContext());
        managerCardView.setOrientation(RecyclerView.HORIZONTAL);
        rvCardView.setAdapter(new HorizontalViewAdapter(searchConnection.getExampleOfDoctors()));
        rvCardView.setLayoutManager(managerCardView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_doctors_spec, searchConnection.getExampleOfSpecs());
        lvList.setAdapter(arrayAdapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.shortToast(getContext(), parent.getItemAtPosition(position).toString());
            }
        });

        return view;
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(String message) {

    }

    @Override
    public Activity getFragment() {
        return getActivity();
    }
}
