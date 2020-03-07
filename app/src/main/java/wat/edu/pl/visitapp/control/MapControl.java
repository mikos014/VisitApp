package wat.edu.pl.visitapp.control;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import wat.edu.pl.visitapp.utils.JsonParser;

public class MapControl
{
    private String distance;

    public String getDistance(double doctorLat, double doctorLong)
    {
        Random r = new Random();
        String number = String.valueOf(r.nextDouble() * 10).substring(0,3);

        return number + "km";
    }

    public String getRouteDistance(double startLat, double startLong, double destLat, double destLong) {
        String distance = "error";
        String status = "error";
        try {
            Log.e("log_tag", "http://maps.googleapis.com/maps/api/directions/json?origin=" + startLat + "," + startLong + "&destination=" + destLat + "," + destLong + "&sensor=false");

//            JSONObject jsonObj = JsonParser.getJSONFromURL("http://maps.googleapis.com/maps/api/directions/json?origin=" + startLat + "," + startLong + "&destination=" + destLat + "," + destLong + "&sensor=false");
            JSONObject jsonObj = JsonParser.getJSONFromURL(getUrl(startLat, startLong, destLat, destLong, "driving"));

            status = jsonObj.getString("status");

            if (status.equalsIgnoreCase("OK"))
            {
                JSONArray routes = jsonObj.getJSONArray("routes");
                JSONObject zero = routes.getJSONObject(0);
                JSONArray legs = zero.getJSONArray("legs");
                JSONObject zero2 = legs.getJSONObject(0);
                JSONObject dist = zero2.getJSONObject("distance");
                distance = dist.getString("text");
            }
            else
            {
                distance = "Too Far";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return distance;
    }

    private String getUrl(double startLat, double startLong, double destLat, double destLong, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + startLat + "," + startLong;
        // Destination of route
        String str_dest = "destination=" + destLat + "," + destLong;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
//        String url = "";
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + "";
        return url;
    }
}
