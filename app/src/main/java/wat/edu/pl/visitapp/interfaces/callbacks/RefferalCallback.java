package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Refferal;

public interface RefferalCallback
{
    void onSuccessSetRefferalList(List<Refferal> refferalList);
    void onFailure(String message);
    Activity getFragment();
}
