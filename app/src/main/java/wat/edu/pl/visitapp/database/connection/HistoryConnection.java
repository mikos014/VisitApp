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
import wat.edu.pl.visitapp.interfaces.callbacks.HistoryCallback;
import wat.edu.pl.visitapp.request.HistoryVisitRequest;
import wat.edu.pl.visitapp.view.authenticated.dialogs.OpinionDialog;

public class HistoryConnection
{
    private HistoryCallback callback;

    public HistoryConnection(HistoryCallback callback) {
        this.callback = callback;
    }

    public void getHistoryVisit(int userId)
    {
        String url = callback.getFragment().getString(R.string.HISTORY_VISIT_URL);
        List<Visit> visits = null;

        try
        {
            visits = new HistoryVisitRequest(url).execute(userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetHistoryList(visits);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
