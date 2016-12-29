package no.morten.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("1")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "no.morten.model.Male")
public class Male extends Person  implements Serializable {
    @Override
    public String toString() {
        return "Male " + super.getFirstName() + " " + super.getLastName() ;
    }
}
