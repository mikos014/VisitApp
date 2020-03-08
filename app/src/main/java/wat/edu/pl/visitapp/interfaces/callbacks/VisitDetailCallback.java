package wat.edu.pl.visitapp.interfaces.callbacks;

import java.util.HashMap;

public interface VisitDetailCallback
{
    void onSuccessSetDates(HashMap hashMap);
    void onSuccessSetRightToBook(boolean hasRefferal);
    void onFailure(String message);
}
