package wat.edu.pl.visitapp.database.connection;

import java.util.concurrent.ExecutionException;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.UserCreds;
import wat.edu.pl.visitapp.database.callbacks.RegisterCallback;
import wat.edu.pl.visitapp.database.request.RegisterRequest;

public class RegisterConnection {
    private RegisterCallback callback;
    private String email, password, name, surname, dateOfBirth, phoneNumber;
    private int sex;

    public RegisterConnection(RegisterCallback callback, String email, String password, String name, String surname, String dateOfBirth, String phoneNumber, int sex) {
        this.callback = callback;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public void register() {
        String url = callback.activity().getString(R.string.REGISTER_URL);
        UserCreds userCreds = new UserCreds();
        userCreds.setEmail(email);
        userCreds.setPassword(password);
        userCreds.setName(name);
        userCreds.setSurname(surname);
        userCreds.setDateOfBirth(dateOfBirth);
        userCreds.setPhoneNumber(phoneNumber);
        userCreds.setSex(sex);

        boolean isNoError = false;
        try {
            isNoError = new RegisterRequest(url).execute(userCreds).get();
        } catch (ExecutionException | InterruptedException e) {
            callback.onFailure("Błąd połączenia");
        }

        if (isNoError)
            callback.onSuccess();
        else
            callback.onFailure("Błąd rejestracji");
    }
}
