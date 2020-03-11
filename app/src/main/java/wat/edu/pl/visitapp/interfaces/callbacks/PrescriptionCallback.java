package wat.edu.pl.visitapp.interfaces.callbacks;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Prescription;

public interface PrescriptionCallback
{
    void onSuccessSetPrescriptionList(List<Prescription> prescriptionList);
    void onFailure(String message);
}
