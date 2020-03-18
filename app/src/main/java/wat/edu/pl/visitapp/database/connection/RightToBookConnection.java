package wat.edu.pl.visitapp.database.connection;

import android.util.Log;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.callbacks.RightToBookCallback;
import wat.edu.pl.visitapp.database.request.RightToBookRequest;

public class RightToBookConnection
{
    private RightToBookCallback callback;

    public RightToBookConnection(RightToBookCallback callback) {
        this.callback = callback;
    }

    public void checkRightToBook(String doctorSpec, int userId)
    {
        String url = callback.activity().getString(R.string.RIGHT_TO_BOOK_URL);
        boolean hasRefferal = false;

        try
        {
            hasRefferal = new RightToBookRequest(url).execute(doctorSpec, String.valueOf(userId)).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailureSetRightToBook("Błąd połączenia");
        }

        callback.onSuccessSetRightToBook(hasRefferal);
    }
}
