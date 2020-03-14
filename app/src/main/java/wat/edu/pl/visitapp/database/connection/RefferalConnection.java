package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.Refferal;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.RefferalCallback;
import wat.edu.pl.visitapp.request.PrescriptionRequest;
import wat.edu.pl.visitapp.request.RefferalRequest;
import wat.edu.pl.visitapp.view.authenticated.fragments.RefferalFragment;

public class RefferalConnection
{
    private RefferalCallback callback;

    public RefferalConnection(RefferalFragment callback) {
        this.callback = callback;
    }

    public void getRefferalList(int userId)
    {
        String url = callback.getFragment().getString(R.string.PRESCRIPTION_URL);
        List<Refferal> refferals = null;

        try
        {
            refferals = new RefferalRequest(url).execute(userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (refferals != null)
            callback.onSuccessSetRefferalList(refferals);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
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
