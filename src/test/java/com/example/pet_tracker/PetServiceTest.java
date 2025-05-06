package com.example.pet_tracker;

import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.model.Pet;
import com.example.pet_tracker.repository.PetRepository;
import com.example.pet_tracker.service.PetService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for PetService class.
 * Uses Mockito to isolate and test service logic independently from repository/database.
 */
@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository mockRepo;

    @InjectMocks
    private PetService service;
    
    /**
     * Test saving a Dog with valid data.
     * Should successfully save and return the same Dog object.Same will work for Cat also.
     */
    @Test
    public void testSaveDog() {
        Dog dog = new Dog("SMALL", 101, true);
        Mockito.when(mockRepo.save(dog)).thenReturn(dog);
        Assertions.assertEquals(dog, service.savePet(dog));
    }
 
    /**
     * Test saving a Cat without a lostTracker value.
     * Should throw IllegalArgumentException as per logic.
     */
    @Test
    public void testCatWithoutLostTrackerThrowsException() {
        Cat cat = new Cat("SMALL", 102, false, null);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.savePet(cat);
        });
    }

     /**
     * Test grouping pets that are out of zone by type and trackerType.
     * Only pets with inZone = false should be included.
     */
    @Test
    public void testGetOutOfZoneGroupedCounts() {
        // Prepare test data
        Pet dog = new Dog("MEDIUM", 1, false);
        Pet cat = new Cat("SMALL", 2, false, true);
    
        List<Pet> pets = Arrays.asList(dog, cat);
    
        Mockito.when(mockRepo.findByInZoneFalse()).thenReturn(pets);
    
        Map<String, Long> result = service.getOutOfZoneGroupedCounts();
    
        assertEquals(2, result.size());
        assertEquals(1L, result.get("Dog-MEDIUM"));
        assertEquals(1L, result.get("Cat-SMALL"));
    }
    
     /**
     * Test fetching all pets from the repository.
     * Should return exactly the list provided by the mock.
     */
    @Test
    public void testGetAllPets() {
        List<Pet> pets = Arrays.asList(new Dog("LARGE", 1, true));
        when(mockRepo.findAll()).thenReturn(pets);

        List<Pet> result = service.getAllPets();

        assertEquals(1, result.size());
        verify(mockRepo, times(1)).findAll();
    }


}
