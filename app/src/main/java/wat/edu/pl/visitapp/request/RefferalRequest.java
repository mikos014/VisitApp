package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wat.edu.pl.visitapp.database.entity.Refferal;

public class RefferalRequest extends AsyncTask<Integer, Void, List<Refferal>> {
    private String url;

    public RefferalRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected List<Refferal> doInBackground(Integer... integers) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            url = url + "/" + integers[0];
            ResponseEntity<Refferal[]> responseEntity = restTemplate.getForEntity(url, Refferal[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return null;
        }
    }

}
