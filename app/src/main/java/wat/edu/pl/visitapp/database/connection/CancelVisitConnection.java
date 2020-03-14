package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.interfaces.callbacks.CancelVisitCallback;
import wat.edu.pl.visitapp.request.CancelVisitRequest;
import wat.edu.pl.visitapp.request.OpinionRequest;

public class CancelVisitConnection
{
    private CancelVisitCallback callback;

    public CancelVisitConnection(CancelVisitCallback callback) {
        this.callback = callback;
    }

    public void cancelTheVisit(int visitId, int userId)
    {
        String url = callback.getFragment().getString(R.string.CANCEL_VISIT_URL);
        boolean isNoError = false;

        try
        {
            isNoError = new CancelVisitRequest(url).execute(visitId, userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
            callback.onSuccessCancel();
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
