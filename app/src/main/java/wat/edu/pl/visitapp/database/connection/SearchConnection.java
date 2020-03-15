package wat.edu.pl.visitapp.database.connection;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.Visit;
import wat.edu.pl.visitapp.interfaces.callbacks.SearchCallback;
import wat.edu.pl.visitapp.request.DoctorSpecRequest;
import wat.edu.pl.visitapp.request.VisitRequest;

public class SearchConnection {
    private SearchCallback callback;

    public SearchConnection(SearchCallback callback) {
        this.callback = callback;
    }

    public void getExampleOfVisits() {
        String url = callback.getFragment().getString(R.string.UNOCCUPIED_VISIT_URL);
        List<Visit> visits = null;
        try {
            visits = new VisitRequest(url).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (visits != null)
            callback.onSuccessSetVisitAds(visits);
        else
            callback.onFailure("Bład serwera");
    }

    public void getExampleOfSpecs() {
        String url = callback.getFragment().getString(R.string.DOCTOR_SPEC_URL);
        List<String> specs = null;
        try {
            specs = new DoctorSpecRequest(url).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (specs != null)
            callback.onSuccessSetDoctorSpecAds(specs);
        else
            callback.onFailure("Bład serwera");

    }

}
