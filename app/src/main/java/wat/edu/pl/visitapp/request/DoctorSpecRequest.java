package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class DoctorSpecRequest extends AsyncTask<Void, Void, List<String>> {
    private String url;

    public DoctorSpecRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected List<String> doInBackground(Void... voids) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<String[]> responseEntity = restTemplate.getForEntity(url, String[].class);

            return Arrays.asList(responseEntity.getBody());
        } catch (RestClientException e) {
            return null;
        }

    }
}