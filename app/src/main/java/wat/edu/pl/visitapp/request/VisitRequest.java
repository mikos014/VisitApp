package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import wat.edu.pl.visitapp.database.entity.Visit;

public class VisitRequest extends AsyncTask<Void, Void, List<Visit>> {
    private String url;

    public VisitRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected List<Visit> doInBackground(Void... voids) {

        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Visit[]> responseEntity = restTemplate.getForEntity(url, Visit[].class);

            return Arrays.asList(responseEntity.getBody());
        }
        catch (RestClientException e) {
            return null;
        }
    }

}
