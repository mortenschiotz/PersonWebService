package no.morten.controllers;

import no.morten.model.Person;
import no.morten.model.Portfolio;
import no.morten.services.PersonService;
import no.morten.services.PortfolioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class PersonController {
    private final static Logger logger = Logger.getLogger(PersonController.class);


    @Autowired
    PersonService svc;

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Integer id, HttpServletResponse response) {

        Person person = svc.getPerson(id);

        logger.info("getting portfolio");
        Future<List<Portfolio>> f = portfolioService.getPortfolio(person.getId());
        logger.info("got portfolio future");

        try {
            List<Portfolio> p = f.get();

            p.stream().filter(pp -> pp.getNumberOfShares() > 1000).forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        logger.info("got portfolio");

        if(person == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }

        return person;
    }
}
