package wat.edu.pl.visitapp.utils;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JsonParser
{
    public static JSONObject getJSONFromURL(String url)
    {
        //initialize
        InputStream is = null;
        String result = "";
        JSONObject jArray = null;

        URL urlAddress = null;

        //http post
        try
        {
            urlAddress = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlAddress.openConnection();
            urlConnection.setRequestMethod("POST");
            is = urlConnection.getInputStream();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }

        //convert response to string
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
        }
        catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }

        //try parse the string to a JSON object
        try
        {
            jArray = new JSONObject(result);
        }
        catch (JSONException e)
        {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jArray;

    }
}
