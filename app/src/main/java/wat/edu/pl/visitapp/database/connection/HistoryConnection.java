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

    public void getHistoryVisit(int userId)
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

        Doctor doctor6 = new Doctor(7, "dr Artur Taczuk", 4.2, "ortopeda");
        Doctor doctor7 = new Doctor(8, "dr hab. Jan Edwin", 4.9, "okulista");

        Visit visit = new Visit(1, date, "10:30", user, doctor6, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828", true);
        Visit visit1 = new Visit(2, date, "17:30", user, doctor7, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828",false);

        list.add(visit);
        list.add(visit1);

        callback.onSuccessSetHistoryList(list);
    }
}
