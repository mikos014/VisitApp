package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface BrowseCallback
{
    void onSuccessSetVisitByQuery(List<Visit> listByQuery);
    void onFailureSetVisitByQuery(String message);
    Activity activity();
}