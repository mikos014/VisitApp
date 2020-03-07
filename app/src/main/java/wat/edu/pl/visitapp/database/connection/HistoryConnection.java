package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.HistoryCallback;
import wat.edu.pl.visitapp.view.authenticated.dialogs.OpinionDialog;

public class HistoryConnection
{
    private HistoryCallback callback;

    public HistoryConnection(HistoryCallback callback) {
        this.callback = callback;
    }

    public List<Visit> getHistoryVisit(User user)
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

        Doctor doctor = new Doctor(1, "lek. Michał Malinowski", 4.7, "lekarz ogólny");

        Visit visit = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828", false);
        Visit visit1 = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828",false);
        Visit visit2 = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828",false);

        list.add(visit);
        list.add(visit1);
        list.add(visit2);

        return list;
    }
}
