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
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, adres, new Response.Listener<String>()
//        {
//            @Override
//            public void onResponse(String response)
//            {
//                try
//                {
//                    JSONObject jsonObject = new JSONObject(response);
//                    abc
//                }
//                catch (JSONException e)
//                {
//                    e.printStackTrace();
//                    callback.onFailure(callback.activity().getString(R.string.responseError) + e.toString());
//                }
//            }
//        },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error)
//                    {
//
//                    }
//                })
//        {
//            @Override
//            protected Map<String, String> getParams()
//            {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//                params.put("name", name);
//                params.put("surname", surname);
//                params.put("dateOfBirth", dateOfBirth);
//                params.put("phoneNumber", phoneNumber);
//                params.put("sex", String.valueOf(sex));
//
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(callback.activity());
//        requestQueue.add(stringRequest);
    }
}
