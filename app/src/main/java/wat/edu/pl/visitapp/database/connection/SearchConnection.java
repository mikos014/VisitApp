package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;

public class SearchConnection
{
    private SearchCallback callback;

    public SearchConnection(SearchCallback callback)
    {
        this.callback = callback;
    }

    public List<Visit> getExampleOfVisits()
    {
//        list.add(new Doctor(1, "lek. Andrzej Polak", 5.0, "Laryngolog"));
//        list.add(new Doctor(42, "dr Adam Kowalski", 4.9, "Lekarz ogólny"));
//        list.add(new Doctor(54, "dr hab. Jacek Wrzesień", 4.7, "Pediatra"));
//        list.add(new Doctor(7, "lek. Marek Adamowski", 4.6, "Chirurg"));

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
        Doctor doctor = new Doctor(1, "lek. Jan Zanberg", 4.7, "lekarz ogólny");

        Visit visit = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "Czumy 1", "228463828", false);
        Visit visit1 = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "Czumy 1", "228463828",false);
        Visit visit2 = new Visit(1, date, "13:30", user, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "Czumy 1", "228463828",false);

        list.add(visit);
        list.add(visit1);
        list.add(visit2);

        return list;
    }

    public List<String> getExampleOfSpecs()
    {
        List<String> list = new LinkedList<>();

        list.add("dentysta");
        list.add("chirurg");
        list.add("ortopeda");
        list.add("ginekolog");
        list.add("lekarz ogólny");
        list.add("okulista");
        list.add("dermatolog");

        Collections.sort(list);

        return list;
    }
}
