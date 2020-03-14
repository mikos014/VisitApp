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

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("query", String.valueOf(strings[0]));
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> request = new HttpEntity<>(null, headers);
            ResponseEntity<Visit[]> responseEntity = restTemplate.postForEntity(url, null, Visit[].class);

            return Arrays.asList(responseEntity.getBody());
        }
        catch (RestClientException e) {
            return null;
        }
    }

}
