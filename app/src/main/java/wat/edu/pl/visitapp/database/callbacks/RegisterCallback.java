package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

public interface RegisterCallback
{
    void onSuccess();
    void onFailure(String message);
    Activity activity();
}
