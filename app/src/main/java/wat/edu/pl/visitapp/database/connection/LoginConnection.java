package wat.edu.pl.visitapp.database.connection;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import wat.edu.pl.visitapp.R;
import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.interfaces.callbacks.ConnectionCallback;

import java.util.HashMap;
import java.util.Map;

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

    public void login()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, adres, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    abc
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                    callback.onFailure(callback.activity().getString(R.string.responseError) + e.toString());
                }

            }
        },
        new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                callback.onFailure(callback.activity().getString(R.string.connectionError) + error.toString());
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(callback.activity());
        requestQueue.add(stringRequest);
    }
}
