package wat.edu.pl.visitapp.database.connection;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.ProfileCallback;

public class ProfileConnection
{
    private ProfileCallback callback;
    private User user;

    public ProfileConnection(ProfileCallback callback) {
        this.callback = callback;
    }

    public void changeEmail(String oldEmail, String newEmail)
    {
        user.setEmail(newEmail);
//        pobierz user.name i ustaw do user
        callback.onSuccess(user, callback.getFragment().getString(R.string.email2));
    }

    public void changePassword(String oldPassword, String newPassword)
    {
//        pobierz user.email i user.name i ustaw do user
        callback.onSuccess(user, callback.getFragment().getString(R.string.password2));
    }

    public void changeNumber(String newNumber)
    {
//        pobierz user.email i user.name i ustaw do user
        callback.onSuccess(user, callback.getFragment().getString(R.string.phoneNumber));
    }
}