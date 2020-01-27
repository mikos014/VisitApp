package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

public interface RegisterCallback
{
    void onSuccess();
    void onFailure(String message);
    Activity activity();
}
