package ca.shubbar.petclinic.model;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-14
 */
public class Person extends BaseEntity{

    private String firstName;
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
