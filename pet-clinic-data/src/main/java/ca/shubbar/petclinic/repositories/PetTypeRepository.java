package ca.shubbar.petclinic.repositories;

import ca.shubbar.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-26
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {


}
