package com.example.pet_tracker.service;

import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Pet;
import com.example.pet_tracker.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Pet savePet(Pet pet) {
        if (pet instanceof Cat) {
            Cat cat = (Cat) pet;
            if (cat.getLostTracker() == null) {
                throw new IllegalArgumentException("Field 'lostTracker' must not be null for Cat");
            }
        }
        return petRepository.save(pet);
    }
    

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Map<String, Long> getOutOfZoneGroupedCounts() {
        List<Pet> outOfZone = petRepository.findByInZoneFalse();
        Map<String, Long> grouped = new HashMap<>();

        for (Pet pet : outOfZone) {
            String key = (pet instanceof Cat ? "Cat" : "Dog") + "-" + pet.getTrackerType().toUpperCase();
            grouped.put(key, grouped.getOrDefault(key, 0L) + 1);
        }

        return grouped;
    }
}
