package wat.edu.pl.visitapp.database.connection;

import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.BookingCallback;

public class BookingConnection
{
    private BookingCallback callback;

    public BookingConnection(BookingCallback callback) {
        this.callback = callback;
    }

    public void bookVisit(Visit visit)
    {
        callback.onSuccessBooking("Wizyta zarezerwowana");
    }
}
