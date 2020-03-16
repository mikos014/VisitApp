package wat.edu.pl.visitapp.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import wat.edu.pl.visitapp.database.entity.UserCreds;

public class RegisterRequest extends AsyncTask<UserCreds, Void, Boolean> {
    private String url;

    public RegisterRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(UserCreds... userCreds) {
        try {
            String url = this.url;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, userCreds[0], null);

            return responseEntity.getStatusCode().value() == 200;
        } catch (RestClientException e) {
            return false;
        }
    }
}
