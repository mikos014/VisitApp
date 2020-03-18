package wat.edu.pl.visitapp.database.connection;

import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.database.callbacks.HistoryCallback;
import wat.edu.pl.visitapp.database.request.HistoryVisitRequest;

public class HistoryConnection {
    private HistoryCallback callback;

    public HistoryConnection(HistoryCallback callback) {
        this.callback = callback;
    }

    public void getHistoryVisit(int userId) {
        String url = callback.getFragment().getString(R.string.HISTORY_VISIT_URL);
        List<Visit> visits = null;

        try {
            visits = new HistoryVisitRequest(url).execute(userId).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetHistoryList(visits);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
