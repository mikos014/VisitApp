package wat.edu.pl.visitapp.database.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Prescription;

public class PrescriptionRequest extends AsyncTask<Integer, Void, List<Prescription>> {
    private String url;

    public PrescriptionRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected List<Prescription> doInBackground(Integer... integers) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            url = url + "/" + integers[0];

            ResponseEntity<Prescription[]> responseEntity = restTemplate.getForEntity(url, Prescription[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return null;
        }
    }

}
