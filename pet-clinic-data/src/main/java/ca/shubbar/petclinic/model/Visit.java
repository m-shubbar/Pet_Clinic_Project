package ca.shubbar.petclinic.model;

import java.time.LocalDate;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-23
 */
public class Visit extends BaseEntity{

    private LocalDate date;
    private String description;
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
