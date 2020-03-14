package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("userId", String.valueOf(integers[0]));
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> request = new HttpEntity<>(null, headers);
            ResponseEntity<Prescription[]> responseEntity = restTemplate.postForEntity(url, request, Prescription[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return null;
        }
    }

}
