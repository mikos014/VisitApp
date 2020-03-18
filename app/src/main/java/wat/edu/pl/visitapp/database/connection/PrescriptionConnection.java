package wat.edu.pl.visitapp.database.connection;

import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Prescription;
import wat.edu.pl.visitapp.database.callbacks.PrescriptionCallback;
import wat.edu.pl.visitapp.database.request.PrescriptionRequest;

public class PrescriptionConnection {
    private PrescriptionCallback callback;

    public PrescriptionConnection(PrescriptionCallback callback) {
        this.callback = callback;
    }

    public void getListOfPrescription(int userId) {
        String url = callback.getFragment().getString(R.string.PRESCRIPTION_URL);
        List<Prescription> prescriptions = null;

        try {
            prescriptions = new PrescriptionRequest(url).execute(userId).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (prescriptions != null)
            callback.onSuccessSetPrescriptionList(prescriptions);
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }
}
