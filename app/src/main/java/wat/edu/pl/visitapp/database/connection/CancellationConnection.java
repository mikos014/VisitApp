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
import wat.edu.pl.visitapp.interfaces.callbacks.CancellationCallback;
import wat.edu.pl.visitapp.request.BrowseVisitRequest;
import wat.edu.pl.visitapp.request.CancellationRequest;

public class CancellationConnection
{
    private CancellationCallback callback;

    public CancellationConnection(CancellationCallback callback) {
        this.callback = callback;
    }

    public void getCancellationVisits(int userId)
    {
        String url = callback.getFragment().getString(R.string.CURRENT_VISIT_URL);
        List<Visit> visits = null;
        try
        {
            visits = new CancellationRequest(url).execute(userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetCancellationVisitList(visits);
        else
            callback.onFailure("Bład serwera");

    }
}
