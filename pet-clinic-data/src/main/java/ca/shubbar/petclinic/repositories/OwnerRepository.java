package ca.shubbar.petclinic.repositories;

import ca.shubbar.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-26
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastname);

}
