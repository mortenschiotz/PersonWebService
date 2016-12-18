package no.morten.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by mortens on 18.12.2016.
 */
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @Column(name = "id")
    private Integer genderId;

    @Column(name = "description")
    private String description;

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
