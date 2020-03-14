package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

public interface BookingCallback
{
    void onSuccessBooking();
    void onFailure(String message);
    Activity getFragment();
}
