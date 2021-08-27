package ca.shubbar.petclinic.bootstrap;

import ca.shubbar.petclinic.model.*;
import ca.shubbar.petclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


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

        Visit catVisit = new Visit();
        catVisit.setPet(mikesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Normal checkup. Sneezy kitty");
        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Kathryn");
        vet1.setLastName("Ortega");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Elma");
        vet2.setLastName("Marjan");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
