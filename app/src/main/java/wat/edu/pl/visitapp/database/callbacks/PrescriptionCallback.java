package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Prescription;

public interface PrescriptionCallback
{
    void onSuccessSetPrescriptionList(List<Prescription> prescriptionList);
    void onFailure(String message);
    Activity getFragment();
}
