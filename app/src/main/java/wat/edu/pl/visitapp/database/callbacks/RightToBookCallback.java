package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

public interface RightToBookCallback
{
    void onSuccessSetRightToBook(boolean hasRefferal);
    void onFailureSetRightToBook(String message);
    Activity activity();
}
