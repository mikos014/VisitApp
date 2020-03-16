package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class CancelVisitRequest extends AsyncTask<Integer, Void, Boolean> {
    private String url;

    public CancelVisitRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            url = url + "/" + integers[0] + "/" + integers[1];
            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url,null, null);

            return responseEntity.getStatusCode().value() == 200;
        } catch (RestClientException e) {
            return false;
        }
    }

}
