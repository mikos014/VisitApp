package wat.edu.pl.visitapp.interfaces.callbacks;

public interface BookingCallback
{
    void onSuccessBooking(String message);
    void onFailure(String message);
}
