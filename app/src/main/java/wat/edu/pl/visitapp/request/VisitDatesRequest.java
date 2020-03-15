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
import java.util.Map;

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

            Map<String, Integer> params = new HashMap<>();
            params.put("userId", integers[0]);

            ResponseEntity<HashMap> responseEntity = restTemplate.getForEntity(url, HashMap.class, params);

            return responseEntity.getBody();
        }
        catch (RestClientException e) {
            return null;
        }
    }

}
