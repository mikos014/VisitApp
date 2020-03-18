package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.callbacks.OpinionCallback;
import wat.edu.pl.visitapp.database.request.OpinionRequest;

public class OpinionConnection {
    private OpinionCallback callback;

    public OpinionConnection(OpinionCallback callback) {
        this.callback = callback;
    }

    public void addOpinion(int visitId, int userId, int numberOfStars) {
        String url = callback.getFragment().getString(R.string.ADD_OPINION_URL);
        boolean isNoError = false;

        try {
            isNoError = new OpinionRequest(url).execute(visitId, userId, numberOfStars).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
            callback.onSuccessAddOpinion();
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
