package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RightToBookRequest extends AsyncTask<Integer, Void, Boolean> {
    private String url;

    public RightToBookRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("visitId", String.valueOf(integers[0]));
            headers.add("userId", String.valueOf(integers[1]));
            headers.add("Content-Type", "application/json");

            HttpEntity<Void> request = new HttpEntity<>(null, headers);
            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, request, null);

            return responseEntity.getStatusCode().value() == 200;
        }
        catch (RestClientException e) {
            return false;
        }
    }
}
