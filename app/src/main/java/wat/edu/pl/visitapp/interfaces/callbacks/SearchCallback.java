package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

public interface SearchCallback
{
    void onSuccess();
    void onFailure(String message);
    Activity getFragment();
}
