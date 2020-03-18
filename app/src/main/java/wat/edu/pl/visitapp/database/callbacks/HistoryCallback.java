package wat.edu.pl.visitapp.database.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface HistoryCallback
{
    void onSuccessSetHistoryList(List<Visit> historyList);
    void onFailure(String message);
    Activity getFragment();
}
