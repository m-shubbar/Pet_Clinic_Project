package ca.shubbar.petclinic.model;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-23
 */
public class Speciality extends BaseEntity{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
