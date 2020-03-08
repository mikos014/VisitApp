package wat.edu.pl.visitapp.interfaces.callbacks;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface BrowseCallback
{
    void onSuccessSetVisitByQuery(List<Visit> listByQuery);
    void onFailure(String message);
}
