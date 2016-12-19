package no.morten.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "person")
public class Female extends Person {
    @Override
    public String toString() {
        return "Female " + super.getFirstName() + " " + super.getLastName();
    }
}
