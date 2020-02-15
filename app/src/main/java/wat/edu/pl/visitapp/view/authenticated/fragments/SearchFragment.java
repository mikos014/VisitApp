package wat.edu.pl.visitapp.view.authenticated.fragments;

import android.app.Activity;
import android.app.SearchManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.connection.SearchConnection;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.utils.ToastUtil;
import wat.edu.pl.visitapp.view.authenticated.adapters.ListViewAdapter;

public class SearchFragment extends Fragment implements SearchCallback
{
    private SearchConnection searchConnection;

    private SearchView svSearch;
    private ListView lvList;

    public SearchFragment()
    {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        svSearch = view.findViewById(R.id.svSearch);
        lvList = view.findViewById(R.id.lvList);

        searchConnection = new SearchConnection(this);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_search_item, searchConnection.getExampleOfSpecs());
        lvList.setAdapter(arrayAdapter);

        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtil.shortToast(getContext(), parent.getItemAtPosition(position).toString());
            }
        });

        return view;
    }

    @Override
    public void onSuccess()
    {

    }

    @Override
    public void onFailure(String message)
    {

    }

    @Override
    public Activity getFragment()
    {
        return getActivity();
    }
}
