package wat.edu.pl.visitapp.database.connection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.view.authenticated.fragments.SearchFragment;

public class SearchConnection
{
    private SearchCallback callback;

    public SearchConnection(SearchFragment callback)
    {
        this.callback = callback;
    }

    public List<Doctor> getExampleOfDoctors()
    {
        List<Doctor> list = new LinkedList<>();

        list.add(new Doctor(1, "lek. Andrzej Polak", 5.0, "Laryngolog"));
        list.add(new Doctor(42, "dr Adam Kowalski", 4.9, "Lekarz ogólny"));
        list.add(new Doctor(54, "dr hab. Jacek Wrzesień", 4.7, "Pediatra"));
        list.add(new Doctor(7, "lek. Marek Adamowski", 4.6, "Chirurg"));

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
