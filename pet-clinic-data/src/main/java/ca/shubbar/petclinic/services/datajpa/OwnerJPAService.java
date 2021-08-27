package ca.shubbar.petclinic.services.datajpa;

import ca.shubbar.petclinic.model.Owner;
import ca.shubbar.petclinic.repositories.OwnerRepository;
import ca.shubbar.petclinic.repositories.PetRepository;
import ca.shubbar.petclinic.repositories.PetTypeRepository;
import ca.shubbar.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-26
 */

@Service
// Spring will skip this profile unless it's active
@Profile("jpadata")
public class OwnerJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {

        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        /*
        Optional<Owner> optionalOwner =  ownerRepository.findById(aLong);
        if(optionalOwner.isPresent()) {
            return optionalOwner.get();
        } else {
            return null;
        }
         */


        // cleaner version :)
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        // Double check that this is the JPA Service
        System.out.println("##################################");
        System.out.println("This is from JPA Service save()");
        System.out.println("##################################");

        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

}
