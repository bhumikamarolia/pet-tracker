package com.example.pet_tracker;

import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.repository.PetRepository;
import com.example.pet_tracker.service.PetService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PetServiceTest {

    @Test
    public void testSaveDog() {
        PetRepository mockRepo = Mockito.mock(PetRepository.class);
        PetService service = new PetService(mockRepo);
        Dog dog = new Dog("SMALL", 101, true);
        Mockito.when(mockRepo.save(dog)).thenReturn(dog);
        Assertions.assertEquals(dog, service.savePet(dog));
    }

    @Test
    public void testCatWithoutLostTrackerThrowsException() {
        PetRepository mockRepo = Mockito.mock(PetRepository.class);
        PetService service = new PetService(mockRepo);
        Cat cat = new Cat("SMALL", 102, false, null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.savePet(cat);
        });
    }
}
