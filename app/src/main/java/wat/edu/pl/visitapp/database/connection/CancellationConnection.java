package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.CancellationCallback;

public class CancellationConnection
{
    private CancellationCallback callback;

    public CancellationConnection(CancellationCallback callback) {
        this.callback = callback;
    }

    public void getCancellationVisits(int userId)
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
        Doctor doctor8 = new Doctor(9, "lek. Wiesław Tadel", 4.7, "kardiolog");
        Doctor doctor9 = new Doctor(10, "dr. Jakub Zaberg", 4.3, "laryngolog");

        Visit visit = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828", false);
        Visit visit1 = new Visit(1, date, "13:30", user, doctor8, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828",false);
        Visit visit2 = new Visit(1, date, "13:30", user, doctor9, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828",false);

        list.add(visit);
        list.add(visit1);
        list.add(visit2);

        callback.onSuccessSetCancellationVisitList(list);
    }
}
