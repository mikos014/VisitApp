package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

import java.util.HashMap;

public interface VisitDetailCallback
{
    void onSuccessSetDates(HashMap hashMap);
    void onFailureSetDates(String message);
    Activity activity();
}
