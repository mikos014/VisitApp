package wat.edu.pl.visitapp.database.connection;

import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.database.callbacks.BrowseCallback;
import wat.edu.pl.visitapp.database.request.BrowseVisitRequest;
import wat.edu.pl.visitapp.database.request.RightToBookRequest;

public class BrowseConnection {
    private BrowseCallback callback;

    public BrowseConnection(BrowseCallback callback) {
        this.callback = callback;
    }

    public void getVisitsLimitByString(String query) {
        String url = callback.activity().getString(R.string.SEARCH_BY_QUERY_URL);
        List<Visit> visits = null;
        try {
            visits = new BrowseVisitRequest(url).execute(query).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailureSetVisitByQuery("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetVisitByQuery(visits);
        else
            callback.onFailureSetVisitByQuery("Bład serwera");
    }
}
