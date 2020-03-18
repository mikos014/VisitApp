package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

public interface OpinionCallback
{
    void onSuccessAddOpinion();
    void onFailure(String message);
    Activity getFragment();
}
