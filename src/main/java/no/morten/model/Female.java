package no.morten.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("2")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "no.morten.model.Female")
public class Female extends Person  implements Serializable {
    @Override
    public String toString() {
        return "Female " + super.getFirstName() + " " + super.getLastName();
    }
}
