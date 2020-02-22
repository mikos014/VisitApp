package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

import wat.edu.pl.visitapp.database.entity.User;

public interface ProfileCallback
{
    void onSuccess(User user, String message);
    void onFailure(String message);
    Activity getFragment();
}
