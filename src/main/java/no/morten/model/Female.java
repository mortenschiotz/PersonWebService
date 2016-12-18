package no.morten.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Female extends Person {
    @Override
    public String toString() {
        return "Female " + super.getFirstName() + " " + super.getLastName();
    }
}
