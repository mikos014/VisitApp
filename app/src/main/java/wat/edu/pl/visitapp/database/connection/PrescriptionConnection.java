package wat.edu.pl.visitapp.database.connection;

import java.util.LinkedList;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.PrescriptionCallback;

public class PrescriptionConnection
{
    private PrescriptionCallback callback;

    public PrescriptionConnection(PrescriptionCallback callback) {
        this.callback = callback;
    }

    public List<Prescription> getListOfPrescription(User user)
    {
        List<Prescription> list = new LinkedList<>();


        return list;
    }
}
