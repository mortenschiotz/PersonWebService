package no.morten.services;

import no.morten.model.Portfolio;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class PortfolioService {
    private final static Logger logger = Logger.getLogger(PortfolioService.class);

    @Async
    public Future<List<Portfolio>> getPortfolio(Integer userId) {
        List<Portfolio> result = null;

        RestTemplate template = new RestTemplate();
        ResponseEntity<Portfolio[]> response = template.getForEntity("http://localhost:8089/shares/1", Portfolio[].class);

        HttpStatus status = response.getStatusCode();
        if (status == HttpStatus.OK) {
            Portfolio[] portfolio = response.getBody();
            result = Arrays.asList(portfolio);
        } else {
            logger.error("got unexpected response " + status);
        }

        logger.error(result.get(1).getTicker());

        return new AsyncResult<>(result);
    }
}
