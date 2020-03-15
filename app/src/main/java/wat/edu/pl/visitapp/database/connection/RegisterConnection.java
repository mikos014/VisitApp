package wat.edu.pl.visitapp.database.connection;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.interfaces.callbacks.RegisterCallback;

public class RegisterConnection
{
    private RegisterCallback callback;
    private String email, password, name, surname, dateOfBirth, phoneNumber;
    private int sex;

    public RegisterConnection(RegisterCallback callback, String email, String password, String name, String surname, String dateOfBirth, String phoneNumber, int sex)
    {
        this.callback = callback;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public void register()
    {

        callback.onSuccess();
    }
}
