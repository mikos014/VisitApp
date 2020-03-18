package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

public interface CancelVisitCallback
{
    void onSuccessCancel();
    void onFailure(String message);
    Activity getFragment();
}
