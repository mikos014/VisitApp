package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.BrowseCallback;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;

public class BrowseConnection
{
    private BrowseCallback callback;

    public BrowseConnection(BrowseCallback callback) {
        this.callback = callback;
    }

    public void getVisitsLimitByString(String query)
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

        User user = new User(1, "kowalski@wp.pl", "Jan", "Kowalski", "19800812", 0, "600000000");
        Doctor doctor = new Doctor(1, "lek. Jan Malinowski", 4.7, "laryngolog");
        Doctor doctor1 = new Doctor(2, "dr Jacek Nowak", 4.6, "laryngolog");
        Doctor doctor2 = new Doctor(2, "dr Adam Kowalski", 4.1, "laryngolog");


        Visit visit = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "01-111 Warszawa","Czumy 1", "228463828", false);
        Visit visit1 = new Visit(1, date, "14:30", user, doctor1, 51.421882,21.924779, "Przychodnia SZPZLO Warszawa Bemowo - Włochy", "00-101 Warszawa","Janiszowska 15", "228463828",false);
        Visit visit2 = new Visit(1, date, "15:00", user, doctor2, 51.421882,21.924779, "SPZOZ Warszawa Wola - Śródmieście - Przychodnia lekarska", "01-001 Warszawa","Ciołka 11", "228463828",false);


        list.add(visit);
        list.add(visit1);
        list.add(visit2);

        callback.onSuccessSetVisitByQuery(list);
    }
}
