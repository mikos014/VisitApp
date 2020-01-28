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
//
//            }
//        },
//        new Response.ErrorListener()
//        {
//            @Override
//            public void onErrorResponse(VolleyError error)
//            {
//                callback.onFailure(callback.activity().getString(R.string.connectionError) + error.toString());
//            }
//        })
//        {
//            @Override
//            protected Map<String, String> getParams()
//            {
//                Map<String, String> params = new HashMap<>();
//                params.put("email", email);
//                params.put("password", password);
//                return params;
//            }
//        };
//
//        RequestQueue requestQueue = Volley.newRequestQueue(callback.activity());
//        requestQueue.add(stringRequest);

        callback.onSuccess(user);
    }
}
