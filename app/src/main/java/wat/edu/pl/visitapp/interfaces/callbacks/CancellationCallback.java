package wat.edu.pl.visitapp.interfaces.callbacks;

public interface CancellationCallback
{
    void onSuccess();
    void onFailure(String message);
}
