package wat.edu.pl.visitapp.database.request;

import android.os.AsyncTask;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import wat.edu.pl.visitapp.database.entity.User;
import wat.edu.pl.visitapp.database.entity.UserCreds;

public class LoginRequest extends AsyncTask<UserCreds, Void, User> {
    private String url;

    public LoginRequest(String url) {
        super();
        this.url = url;
    }

    @Override
    protected User doInBackground(UserCreds... userCreds) {
        try {
            String url = this.url;

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

            ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, userCreds[0], User.class);

            return responseEntity.getBody();
        } catch (RestClientException e) {
            return null;
        }
    }
}
