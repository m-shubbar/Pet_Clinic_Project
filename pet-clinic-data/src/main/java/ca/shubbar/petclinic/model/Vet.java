package ca.shubbar.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-14
 */

@Entity
@Table(name = "vets")
public class Vet extends Person {

    // JPA will try to load everything all in once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
                inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
