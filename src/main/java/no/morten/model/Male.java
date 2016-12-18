package no.morten.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Male extends Person {
    @Override
    public String toString() {
        return "Male " + super.getFirstName() + " " + super.getLastName() ;
    }
}
