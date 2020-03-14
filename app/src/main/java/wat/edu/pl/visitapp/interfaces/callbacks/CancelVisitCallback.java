package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

public interface CancelVisitCallback
{
    void onSuccessCancel();
    void onFailure(String message);
    Activity getFragment();
}
