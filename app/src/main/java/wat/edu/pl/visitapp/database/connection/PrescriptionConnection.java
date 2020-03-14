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
import wat.edu.pl.visitapp.database.entity.Medicine;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.PrescriptionCallback;
import wat.edu.pl.visitapp.request.PrescriptionRequest;

public class PrescriptionConnection
{
    private PrescriptionCallback callback;

    public PrescriptionConnection(PrescriptionCallback callback) {
        this.callback = callback;
    }

    public void getListOfPrescription(int userId)
    {
        String url = callback.getFragment().getString(R.string.PRESCRIPTION_URL);
        List<Prescription> prescriptions = null;

        try
        {
            prescriptions = new PrescriptionRequest(url).execute(userId).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (prescriptions != null)
            callback.onSuccessSetPrescriptionList(prescriptions);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
//TODO remove if unuse

//    public Prescription getPrescription(User user, int i)
//    {
//        for (Prescription p: getListOfPrescription(user))
//        {
//            if (p.getPrescriptionId() == i)
//                return p;
//        }
//        return null;
//    }
}
