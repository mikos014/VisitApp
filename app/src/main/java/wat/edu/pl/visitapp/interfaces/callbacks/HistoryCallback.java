package wat.edu.pl.visitapp.interfaces.callbacks;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface HistoryCallback
{
    void onSuccessSetHistoryList(List<Visit> historyList);
    void onFailure(String message);
}
