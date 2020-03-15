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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import wat.edu.pl.visitapp.database.entity.Visit;

public class BrowseVisitRequest extends AsyncTask<String, Void, List<Visit>> {
    private String url;

    public BrowseVisitRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected List<Visit> doInBackground(String... strings) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            Map<String, String> params = new HashMap<>();
            params.put("userId", strings[0]);

            ResponseEntity<Visit[]> responseEntity = restTemplate.getForEntity(url, Visit[].class, params);

            return Arrays.asList(responseEntity.getBody());
        }
        catch (RestClientException e) {
            return null;
        }
    }

}
