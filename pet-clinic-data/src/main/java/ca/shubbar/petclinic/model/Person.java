package ca.shubbar.petclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-14
 */
@MappedSuperclass
public class Person extends BaseEntity{

    // Hibernate will assume these names anyways, we used the explicit naming here
    // Hibernate follows that CamelCase naming convention

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
