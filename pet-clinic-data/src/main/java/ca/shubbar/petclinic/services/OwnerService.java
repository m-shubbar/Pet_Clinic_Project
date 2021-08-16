package ca.shubbar.petclinic.services;

import ca.shubbar.petclinic.model.Owner;


/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-15
 */
public interface OwnerService extends CrudService<Owner, Long>{

    // Additional method
    Owner findByLastName(String lastName);

}
