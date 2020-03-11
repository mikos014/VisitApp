package wat.edu.pl.visitapp.database.connection;

import wat.edu.pl.visitapp.interfaces.callbacks.CancelVisitCallback;

public class CancelVisitConnection
{
    private CancelVisitCallback callback;

    public CancelVisitConnection(CancelVisitCallback callback) {
        this.callback = callback;
    }

    public void cancelTheVisit(int visitId, int userId)
    {
        callback.onSuccessCancel("Wizyta odwołana");
    }
}
