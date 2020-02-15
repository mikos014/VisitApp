package wat.edu.pl.visitapp.database.connection;

import java.util.ArrayList;
import java.util.List;

import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.view.authenticated.fragments.SearchFragment;

public class SearchConnection
{
    private SearchCallback callback;

    public SearchConnection(SearchFragment callback)
    {
        this.callback = callback;
    }

    public List<String> getExampleOfSpecs()
    {
        List<String> list = new ArrayList<>();

        list.add("dentysta");
        list.add("hirurg");
        list.add("ortopeda");
        list.add("ginekolog");

        return list;
    }


}
