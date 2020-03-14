package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface CancellationCallback
{
    void onSuccessSetCancellationVisitList(List<Visit> list);
    void onFailure(String message);
    Activity getFragment();
}
