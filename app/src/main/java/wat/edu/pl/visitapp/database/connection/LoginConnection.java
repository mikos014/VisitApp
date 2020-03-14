package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.UserCreds;
import wat.edu.pl.visitapp.request.LoginRequest;
import wat.edu.pl.visitapp.interfaces.callbacks.LoginCallback;

public class LoginConnection
{
    private LoginCallback callback;

    private String email, password;

    public LoginConnection(LoginCallback callback, String email, String password)
    {
        this.callback = callback;
        this.email = email;
        this.password = password;
    }

    public void login()
    {
        User user = null;
        UserCreds userCreds = new UserCreds();
        userCreds.setEmail(email);
        userCreds.setPassword(password);

        String url = callback.activity().getString(R.string.LOGIN_URL);
        try
        {
            user = new LoginRequest(url).execute(userCreds).get();
        }
        catch (ExecutionException | InterruptedException e)
        {
            callback.onFailure("Błąd połączenia");
        }

//        if (user != null)
            callback.onSuccess(user);
//        else
//            callback.onFailure("Bład serwera");

    }
}
