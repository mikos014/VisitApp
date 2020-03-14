package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import wat.edu.pl.visitapp.database.entity.Visit;

public class BookVisitRequest extends AsyncTask<Visit, Void, Boolean> {
    private String url;

    public BookVisitRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(Visit... visits) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, visits[0], null);

            return responseEntity.getStatusCode().value() == 200;
        }
        catch (RestClientException e) {
            return false;
        }
    }

}
