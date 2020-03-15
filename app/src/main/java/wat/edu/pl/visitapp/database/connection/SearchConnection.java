package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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

    public void getExampleOfVisits()
    {
//        list.add(new Doctor(1, "lek. Andrzej Polak", 5.0, "Laryngolog"));
//        list.add(new Doctor(42, "dr Adam Kowalski", 4.9, "Lekarz ogólny"));
//        list.add(new Doctor(54, "dr hab. Jacek Wrzesień", 4.7, "Pediatra"));
//        list.add(new Doctor(7, "lek. Marek Adamowski", 4.6, "Chirurg"));

        List<Visit> list = new LinkedList<>();

        Date date1 = null;
        Date date2 = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        try
        {
            date1 = sdf.parse("28.02.2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User(1, "kowalski@wp.pl", "Jan", "Kowalski", "19800812", 0, "600000000");
        Doctor doctor = new Doctor(1, "lek. Michał Dyga", 4.7, "lekarz ogólny");
        Doctor doctor1 = new Doctor(2, "dr Jacek Nowak", 4.6, "laryngolog");
        Doctor doctor2 = new Doctor(3, "dr hab. Jan Babic", 4.9, "pediatra");
        Doctor doctor3 = new Doctor(4, "lek. Mariusz Nach", 4.7, "neurolog");
        Doctor doctor4 = new Doctor(5, "dr. Jan Hadan", 4.5, "kardiolog");
        Doctor doctor5 = new Doctor(6, "lek. Wojciech Wac", 4.1, "lekarz ogólny");


        Visit visit = new Visit(1, date2, "11:30", null, doctor, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463828", false);
        Visit visit1 = new Visit(2, date1, "13:30", null, doctor1, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463843",false);
        Visit visit2 = new Visit(3, date1, "14:00", null, doctor2, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "228463800",false);

        Visit visit3 = new Visit(4, date1, "12:30", null, doctor3, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "225043929", false);
        Visit visit4 = new Visit(5, date1, "13:30", null, doctor4, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "229504030",false);
        Visit visit5 = new Visit(6, date2, "14:00", null, doctor5, 51.421882,21.924779, "Przychodnia Rejonowa SZPZLO Warszawa Bemowo", "00-001 Warszawa","Czumy 1", "223882210",false);
        list.add(visit);
        list.add(visit1);
        list.add(visit2);
        list.add(visit3);
        list.add(visit4);
        list.add(visit5);

        callback.onSuccessSetVisitAds(list);
    }

    public void getExampleOfSpecs()
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

        callback.onSuccessSetDoctorSpecAds(list);
    }

}
