package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class VisitDatesRequest extends AsyncTask<Integer, Void, HashMap> {
    private String url;

    public VisitDatesRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected HashMap doInBackground(Integer... integers) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("visitId", String.valueOf(integers[0]));
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> request = new HttpEntity<>(null, headers);
            ResponseEntity<HashMap> responseEntity = restTemplate.postForEntity(url, request, HashMap.class);

            return responseEntity.getBody();
        }
        catch (RestClientException e) {
            return null;
        }
    }

}
