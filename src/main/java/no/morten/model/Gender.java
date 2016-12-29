package no.morten.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mortens on 18.12.2016.
 */
@Entity
@Table(name = "gender")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "no.morten.model.Gender")
public class Gender implements Serializable {
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
