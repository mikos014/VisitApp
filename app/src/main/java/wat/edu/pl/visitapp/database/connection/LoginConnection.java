package wat.edu.pl.visitapp.database.connection;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.LoginCallback;

public class LoginConnection
{
    private LoginCallback callback;

    private String email, password;
    private User user;

    public LoginConnection(LoginCallback callback, String email, String password, User user)
    {
        this.callback = callback;
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public void login()
    {

        callback.onSuccess(user);
    }
}
