package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

public interface OpinionCallback
{
    void onSuccessAddOpinion();
    void onFailure(String message);
    Activity getFragment();
}
