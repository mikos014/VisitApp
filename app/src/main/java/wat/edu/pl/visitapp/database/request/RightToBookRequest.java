package wat.edu.pl.visitapp.database.request;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RightToBookRequest extends AsyncTask<String, Void, Boolean> {
    private String url;

    public RightToBookRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            url = url + "?spec=" + strings[0] + "&userId=" + strings[1];
            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, null, Void.class);

            return responseEntity.getStatusCode().value() == 200;
        } catch (RestClientException e) {
            return false;
        }
    }

}
