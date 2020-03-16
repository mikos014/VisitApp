package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.BookingCallback;
import wat.edu.pl.visitapp.request.BookVisitRequest;

public class BookingConnection {
    private BookingCallback callback;

    public BookingConnection(BookingCallback callback) {
        this.callback = callback;
    }

    public void bookVisit(Visit visit) {
        String url = callback.getFragment().getString(R.string.CANCEL_VISIT_URL);
        boolean isNoError = false;

        try {
            isNoError = new BookVisitRequest(url).execute(visit).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
            callback.onSuccessBooking();
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
