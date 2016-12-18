package no.morten.controllers;

import no.morten.model.Person;
import no.morten.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonService svc;

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable("id") Integer id) {
        Person person = svc.getPerson(id);

        return person;
    }
}
