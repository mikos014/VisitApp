package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

public interface BookingCallback
{
    void onSuccessBooking();
    void onFailure(String message);
    Activity getFragment();
}
