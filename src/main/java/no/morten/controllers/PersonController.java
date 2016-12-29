package no.morten.controllers;

import no.morten.model.Person;
import no.morten.model.Portfolio;
import no.morten.services.PersonService;
import no.morten.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService svc;

    @Autowired
    PortfolioService portfolioService;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Integer id, HttpServletResponse response) {

        Person person = svc.getPerson(id);

        List<Portfolio> portfolio = portfolioService.getPortfolio(person.getId());

        if(person == null) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }

        return person;
    }
}
