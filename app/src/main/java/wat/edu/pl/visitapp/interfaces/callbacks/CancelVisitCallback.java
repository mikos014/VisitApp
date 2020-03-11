package wat.edu.pl.visitapp.interfaces.callbacks;

public interface CancelVisitCallback
{
    void onSuccessCancel(String message);
    void onFailure(String message);
}
