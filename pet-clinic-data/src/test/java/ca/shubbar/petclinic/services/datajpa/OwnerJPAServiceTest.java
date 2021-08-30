package ca.shubbar.petclinic.services.datajpa;

import ca.shubbar.petclinic.model.Owner;
import ca.shubbar.petclinic.repositories.OwnerRepository;
import ca.shubbar.petclinic.repositories.PetRepository;
import ca.shubbar.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    private static final String LAST_NAME = "mustafa";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJPAService service;

    Owner theOwner;

    @BeforeEach
    void setUp() {
        theOwner = Owner.builder().id(1l).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(theOwner);

        Owner theOwner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, theOwner.getLastName());

        // redundant but for demonstration
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownersList = new HashSet<>();
        ownersList.add(Owner.builder().id(1l).build());
        ownersList.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(ownersList);
        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(theOwner));
        Owner owner = service.findById(1l);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1l);
        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1l).build();
        when(ownerRepository.save(any())).thenReturn(theOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(theOwner);
        // as the original implementation not returning a value, good to use verify()
        // default is time() 1
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(ownerRepository).deleteById(anyLong());
    }
}