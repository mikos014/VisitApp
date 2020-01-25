package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;
import wat.edu.pl.visitapp.database.entity.User;

public interface ConnectionCallback
{
    void onSuccess(User user);
    void onFailure(String message);
    Activity activity();
}
