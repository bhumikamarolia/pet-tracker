package com.example.pet_tracker.service;

import com.example.pet_tracker.dto.CatDTO;
import com.example.pet_tracker.dto.DogDTO;
import com.example.pet_tracker.dto.PetResponseDTO;
import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.model.Pet;
import com.example.pet_tracker.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class that handles business logic for managing pets.
 */
@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
   
     /**
     * Saves a pet to the repository.
     * If the pet is a Cat, it validates that the 'lostTracker' field is not null.
     *
     * @param pet the pet to be saved (Dog or Cat)
     * @return the saved Pet entity
     * @throws IllegalArgumentException if Cat has null 'lostTracker' field
     */
    public Pet savePet(Pet pet) {
        if (pet instanceof Cat) {
            Cat cat = (Cat) pet;
            if (cat.getLostTracker() == null) {
                throw new IllegalArgumentException("Field 'lostTracker' must not be null for Cat");
            }
        }
        return petRepository.save(pet);
    }
    
    //Retrieves all pets from the repository.
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    
    //Retrieves all pets that are out of zone and groups them by type and tracker size
    public Map<String, Long> getOutOfZoneGroupedCounts() {
        List<Pet> outOfZone = petRepository.findByInZoneFalse();
        Map<String, Long> grouped = new HashMap<>();

        for (Pet pet : outOfZone) {
            String key = (pet instanceof Cat ? "Cat" : "Dog") + "-" + pet.getTrackerType().toUpperCase();
            grouped.put(key, grouped.getOrDefault(key, 0L) + 1);
        }

        return grouped;
    }

    public Dog mapToDogEntity(DogDTO dto) {
    return new Dog(dto.getTrackerType(), dto.getOwnerId(), dto.getInZone());
    }

    public Cat mapToCatEntity(CatDTO dto) {
        return new Cat(dto.getTrackerType(), dto.getOwnerId(), dto.getInZone(), dto.getLostTracker());
    }

    public PetResponseDTO mapToResponse(Pet pet) {
    String petType = (pet instanceof Cat) ? "CAT" : "DOG";
    return new PetResponseDTO(
        pet.getId(),
        pet.getTrackerType(),
        pet.getOwnerId(),
        pet.getInZone(),
        petType
    );
}

}
