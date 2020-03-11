package wat.edu.pl.visitapp.database.connection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Doctor;
import wat.edu.pl.visitapp.database.entity.Medicine;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.PrescriptionCallback;

public class PrescriptionConnection
{
    private PrescriptionCallback callback;

    public PrescriptionConnection(PrescriptionCallback callback) {
        this.callback = callback;
    }

    public void getListOfPrescription(int userId)
    {
        List<Prescription> list = new LinkedList<>();

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

        Medicine medicine1 = new Medicine(1, "Apap", "dożylnie", "10ml", "1ml rano i wieczorem przez 3dni");
        Medicine medicine2 = new Medicine(1, "ibuprofen", "w tabletkach", "2mg", "1ml rano przez 4dni");
        List<Medicine> medicineList = new LinkedList<>();
        medicineList.add(medicine1);
        medicineList.add(medicine2);

        User user = new User(1, "j.kowalski@wp.pl", "Jan", "Kowalski", "19800812", 0, "600000000");
        Doctor doctor = new Doctor(1, "lek. Marek Nowak", 4.6, "lekarz ogólny");

        Prescription p1 = new Prescription(1, "0003424", date, datePlus30, "Warszawa", doctor, user, medicineList, "");
        Prescription p2 = new Prescription(2, "0003543", date, datePlus30, "Warszawa", doctor, user, medicineList, "");

        list.add(p1);
        list.add(p2);
        callback.onSuccessSetPrescriptionList(list);
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
