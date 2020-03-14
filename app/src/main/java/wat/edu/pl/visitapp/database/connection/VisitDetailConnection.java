package wat.edu.pl.visitapp.database.connection;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.interfaces.callbacks.VisitDetailCallback;
import wat.edu.pl.visitapp.request.RightToBookRequest;
import wat.edu.pl.visitapp.request.VisitDatesRequest;

public class VisitDetailConnection
{
    private VisitDetailCallback callback;

    public VisitDetailConnection(VisitDetailCallback callback) {
        this.callback = callback;
    }

    public void getDatesOfVisits(int visitId)
    {
        String url = callback.activity().getString(R.string.GET_UNOCCUPIED_DATES_URL);

        HashMap<String, List<String>> dates = null;

        try
        {
            dates = new VisitDatesRequest(url).execute(visitId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (dates != null)
            callback.onSuccessSetDates(dates);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
        callback.onSuccessSetDates(dates);
    }

    public void checkRightToBook(int visitId, int userId)
    {
        String url = callback.activity().getString(R.string.ADD_OPINION_URL);
        boolean hasRefferal = false;

        try
        {
            hasRefferal = new RightToBookRequest(url).execute(visitId, userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        callback.onSuccessSetRightToBook(hasRefferal);
    }
}
