package ca.shubbar.petclinic.bootstrap;

import ca.shubbar.petclinic.model.Owner;
import ca.shubbar.petclinic.model.Pet;
import ca.shubbar.petclinic.model.PetType;
import ca.shubbar.petclinic.model.Vet;
import ca.shubbar.petclinic.services.OwnerService;
import ca.shubbar.petclinic.services.PetTypeService;
import ca.shubbar.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-18
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mustafa");
        owner1.setLastName("Sh.");
        owner1.setAddress("123 Good Street West");
        owner1.setCity("Toronto");
        owner1.setTelephone("12341234");

        Pet mustafasPet = new Pet();
        mustafasPet.setPetType(savedDogPetType);
        mustafasPet.setOwner(owner1);
        mustafasPet.setBirthDate(LocalDate.now());
        mustafasPet.setName("Belly");
        owner1.getPets().add(mustafasPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mike");
        owner2.setLastName("Ok.");
        owner2.setAddress("123 Bad Street West");
        owner2.setCity("Milton");
        owner2.setTelephone("654654654");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner2);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Cherry");
        owner2.getPets().add(mikesPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kathryn");
        vet1.setLastName("Ortega");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Elma");
        vet2.setLastName("Marjan");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
