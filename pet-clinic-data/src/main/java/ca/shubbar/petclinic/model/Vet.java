package ca.shubbar.petclinic.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-14
 */
public class Vet extends Person {

    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
