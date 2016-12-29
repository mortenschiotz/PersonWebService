package no.morten.services;


import no.morten.model.Person;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    private static SessionFactory sessionFactory = null;
    private final static Logger logger = Logger.getLogger(PersonService.class);


    public Person getPerson(Integer id) {
        Person person = null;

        try(Session session = getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            person = session.get(Person.class, id);
            logger.info("got person " + person);

            tx.commit();
        }

        return person;
    }

    private static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }

        return sessionFactory;
    }
}
