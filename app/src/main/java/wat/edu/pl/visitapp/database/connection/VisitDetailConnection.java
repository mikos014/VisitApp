package wat.edu.pl.visitapp.database.connection;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.VisitDetailCallback;

public class VisitDetailConnection
{
    private VisitDetailCallback callback;

    public VisitDetailConnection(VisitDetailCallback callback) {
        this.callback = callback;
    }

    public void getDatesOfVisits(int visitId)
    {
        HashMap<String, List<String>> dates = new HashMap<>();

        List<String> hours = new LinkedList<>();
        hours.add("13:00");
        hours.add("14:00");
        hours.add("15:00");
        dates.put("26.03.2020", hours);

        dates.put("27.03.2020", hours);

        dates.put("28.03.2020", hours);

        callback.onSuccessSetDates(dates);
    }

    public void checkRightToBook(int visitId, int userId)
    {
        callback.onSuccessSetRightToBook(true);
    }
}
