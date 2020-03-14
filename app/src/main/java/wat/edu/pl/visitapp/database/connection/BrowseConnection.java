package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.BrowseCallback;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.request.BrowseVisitRequest;
import wat.edu.pl.visitapp.request.VisitRequest;

public class BrowseConnection
{
    private BrowseCallback callback;

    public BrowseConnection(BrowseCallback callback) {
        this.callback = callback;
    }

    public void getVisitsLimitByString(String query)
    {
        String url = callback.activity().getString(R.string.SEARCH_BY_QUERY_URL);
        List<Visit> visits = null;
        try
        {
            visits = new BrowseVisitRequest(url).execute(query).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetVisitByQuery(visits);
        else
            callback.onFailure("Bład serwera");
    }
}
