package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.RefferalCallback;
import wat.edu.pl.visitapp.view.authenticated.fragments.RefferalFragment;

public class RefferalConnection
{
    private RefferalCallback callback;

    public RefferalConnection(RefferalFragment callback) {
        this.callback = callback;
    }

    public List<Refferal> getRefferalList(User user) {
        List<Refferal> list = new LinkedList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        Date date = null;

        try
        {
            date = sdf.parse("28.02.2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Doctor doctor = new Doctor(1, "lek. Michał Malinowski", 4.7, "lekarz ogólny");

        Refferal refferal = new Refferal(1, "00002124361", date, "Warszawa", doctor, "laryngolog", user, "");
        Refferal refferal2 = new Refferal(2, "0000212141", date, "Warszawa", doctor, "dermatolog", user, "");
        list.add(refferal);
        list.add(refferal2);

        return list;
    }
}
