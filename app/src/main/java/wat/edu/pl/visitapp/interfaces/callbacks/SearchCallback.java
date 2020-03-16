package wat.edu.pl.visitapp.interfaces.callbacks;

import android.app.Activity;

import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public interface SearchCallback
{
    void onSuccessSetVisitAds(List<Visit> visitList);
    void onSuccessSetDoctorSpecAds(List<String> specList);
    void onFailureSetVisitAds(String message);
    void onFailureSetDoctorSpecAds(String message);
    Activity getFragment();
}
