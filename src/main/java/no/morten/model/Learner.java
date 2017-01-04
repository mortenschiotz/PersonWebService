package no.morten.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Learner {
    private Integer parentDepartmentId;
    private String password;
    private String firstName;
    private String lastName;
}
