package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

import wat.edu.pl.visitapp.database.entity.User;

public interface ProfileCallback
{
    void onSuccess(User user, String message);
    void onFailure(String message);
    Activity getFragment();
}
