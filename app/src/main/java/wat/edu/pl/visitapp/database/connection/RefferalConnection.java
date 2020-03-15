package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public void getRefferalList(User user) {
        List<Refferal> list = new LinkedList<>();

        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");

        try
        {
            date = sdf.parse("28.02.2020");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 30);
        Date datePlus30 = c.getTime();

        Doctor doctor3 = new Doctor(4, "lek. Mariusz Nach", 4.7, "neurolog");
        Doctor doctor4 = new Doctor(5, "dr. Jan Hadan", 4.5, "kardiolog");

        Refferal refferal = new Refferal(1, "00002124361", date, datePlus30,"Warszawa", doctor3, "laryngolog", user, "");
        Refferal refferal2 = new Refferal(2, "0000212141", date, datePlus30,"Warszawa", doctor4, "dermatolog", user, "");
        list.add(refferal);
        list.add(refferal2);

        callback.onSuccessSetRefferalList(list);
    }
//TODO remove if ususe

//    public Refferal getRefferal(User user, int i)
//    {
//        for (Refferal r: getRefferalList(user))
//        {
//            if (r.getRefferalId() == i)
//                return r;
//        }
//        return null;
//    }
}
