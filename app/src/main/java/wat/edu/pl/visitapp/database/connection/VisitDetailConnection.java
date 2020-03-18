package wat.edu.pl.visitapp.database.connection;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.callbacks.VisitDetailCallback;
import wat.edu.pl.visitapp.database.request.RightToBookRequest;
import wat.edu.pl.visitapp.database.request.VisitDatesRequest;

public class VisitDetailConnection {
    private VisitDetailCallback callback;

    public VisitDetailConnection(VisitDetailCallback callback) {
        this.callback = callback;
    }

    public void getDatesOfVisits(int visitId) {
        String url = callback.activity().getString(R.string.GET_UNOCCUPIED_DATES_URL);

        HashMap dates = null;

        try {
            dates = new VisitDatesRequest(url).execute(visitId).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailureSetDates("Błąd połączenia");
        }

        if (dates != null)
            callback.onSuccessSetDates(dates);
        else
            callback.onFailureSetDates("Błąd serwera. Proszę spróbować później.");
        callback.onSuccessSetDates(dates);
    }

}
