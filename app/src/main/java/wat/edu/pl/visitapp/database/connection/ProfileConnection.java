package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.UserCreds;
import wat.edu.pl.visitapp.interfaces.callbacks.ProfileCallback;
import wat.edu.pl.visitapp.request.ProfileRequest;

public class ProfileConnection
{
    private ProfileCallback callback;
    private User user;

    public ProfileConnection(ProfileCallback callback, User user) {
        this.callback = callback;
        this.user = user;
    }

    public void changeEmail(String oldEmail, String newEmail)
    {
        UserCreds userCreds = new UserCreds();
        userCreds.setOldEmail(oldEmail);
        userCreds.setEmail(newEmail);
//        pobierz user.name i ustaw do user

        String url = callback.getFragment().getString(R.string.CHANGE_EMAIL_URL);
        boolean isNoError = false;

        try
        {
            isNoError = new ProfileRequest(url).execute(userCreds).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
        {
            user.setEmail(newEmail);
            callback.onSuccess(user, callback.getFragment().getString(R.string.email2));
        }
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
        callback.onSuccess(user, callback.getFragment().getString(R.string.email2));
    }

    public void changePassword(String oldPassword, String newPassword)
    {
        UserCreds userCreds = new UserCreds();
        userCreds.setOldPassword(oldPassword);
        userCreds.setPassword(newPassword);

        String url = callback.getFragment().getString(R.string.CHANGE_PASSWORD_URL);
        boolean isNoError = false;

        try
        {
            isNoError = new ProfileRequest(url).execute(userCreds).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
        {
            callback.onSuccess(user, callback.getFragment().getString(R.string.password2));
        }
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");
    }

    public void changeNumber(String newNumber)
    {
        UserCreds userCreds = new UserCreds();
        userCreds.setPhoneNumber(newNumber);

        String url = callback.getFragment().getString(R.string.CHANGE_PHONE_NUMBER_URL);
        boolean isNoError = false;

        try
        {
            isNoError = new ProfileRequest(url).execute(userCreds).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
        {
            callback.onSuccess(user, callback.getFragment().getString(R.string.phoneNumber));
        }
        else
            callback.onFailure("Błąd serwera. Proszę spróbować później.");

    }
}