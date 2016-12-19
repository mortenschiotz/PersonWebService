package no.morten.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "person")
public class Male extends Person {
    @Override
    public String toString() {
        return "Male " + super.getFirstName() + " " + super.getLastName() ;
    }
}
