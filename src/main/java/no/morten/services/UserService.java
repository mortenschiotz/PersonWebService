package no.morten.services;

import no.morten.model.Learner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserService {
    public Learner getLearner(Integer userId) {
        Learner learner = null;
        RestTemplate template = new RestTemplate();
        ResponseEntity<Learner> response = template.getForEntity("http://localhost:8089/shares/" + userId, Learner.class);

        HttpStatus status = response.getStatusCode();
        if (status == HttpStatus.OK) {
            learner = response.getBody();
        }

        return learner;
    }

}
