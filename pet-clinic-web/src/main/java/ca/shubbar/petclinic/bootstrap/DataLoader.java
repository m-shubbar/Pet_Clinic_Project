package ca.shubbar.petclinic.bootstrap;

import ca.shubbar.petclinic.model.Owner;
import ca.shubbar.petclinic.model.Vet;
import ca.shubbar.petclinic.services.OwnerService;
import ca.shubbar.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-18
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mustafa");
        owner1.setLastName("Sh.");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setLastName("Mike");
        owner2.setLastName("Ok.");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Kathryn");
        vet1.setLastName("Ortega");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Elma");
        vet2.setLastName("Marjan");
        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
