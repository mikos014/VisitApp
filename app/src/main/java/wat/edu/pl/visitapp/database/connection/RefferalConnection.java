package wat.edu.pl.visitapp.database.connection;

import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.database.callbacks.RefferalCallback;
import wat.edu.pl.visitapp.database.request.RefferalRequest;
import wat.edu.pl.visitapp.view.authenticated.fragments.RefferalFragment;

public class RefferalConnection {
    private RefferalCallback callback;

    public RefferalConnection(RefferalFragment callback) {
        this.callback = callback;
    }

    public void getRefferalList(int userId) {
        String url = callback.getFragment().getString(R.string.REFFERAL_URL);
        List<Refferal> refferals = null;

        try {
            refferals = new RefferalRequest(url).execute(userId).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (refferals != null)
            callback.onSuccessSetRefferalList(refferals);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
