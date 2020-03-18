package wat.edu.pl.visitapp.database.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import wat.edu.pl.visitapp.database.entity.UserCreds;

public class ProfileRequest extends AsyncTask<UserCreds, Void, Boolean> {
    private String url;

    public ProfileRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected Boolean doInBackground(UserCreds... userCreds) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ResponseEntity<Void> responseEntity = restTemplate.postForEntity(url, userCreds, null);

            return responseEntity.getStatusCode().value() == 200;
        } catch (RestClientException e) {
            return false;
        }
    }
}
