package wat.edu.pl.visitapp.database.connection;

import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.ConnectionCallback;

public class LoginConnection
{
    private ConnectionCallback callback;

    private String email, password;
    private User user;

    public LoginConnection(ConnectionCallback callback, String email, String password, User user)
    {
        this.callback = callback;
        this.email = email;
        this.password = password;
        this.user = user;
    }

    private void login()
    {

    }
}
