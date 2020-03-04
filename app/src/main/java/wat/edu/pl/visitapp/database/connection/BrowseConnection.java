package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;

public class BrowseConnection
{
    private SearchCallback callback;

    public BrowseConnection(SearchCallback callback) {
        this.callback = callback;
    }

    public List<Visit> getVisitsLimitByString(String query)
    {
        List<Visit> list = new LinkedList<>();

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        try
        {
            date = sdf.parse("28.02.2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User(1, "j.kowalski@wp.pl", "Jan", "Kowalski", "19800812", 0, "600000000");
        Doctor doctor = new Doctor(1, "lek. Michał Malinowski", 4.7, "lekarz ogólny");

        Visit visit = new Visit(1, date, "13:30", user, doctor, false);
        Visit visit1 = new Visit(1, date, "13:30", user, doctor, false);
        Visit visit2 = new Visit(1, date, "13:30", user, doctor, false);

        list.add(visit);
        list.add(visit1);
        list.add(visit2);

        return list;
    }
}
