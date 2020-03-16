package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

import java.util.HashMap;

public interface VisitDetailCallback
{
    void onSuccessSetDates(HashMap hashMap);
    void onSuccessSetRightToBook(boolean hasRefferal);
    void onFailureSetDates(String message);
    void onFailureSetRightToBook(String message);
    Activity activity();
}
