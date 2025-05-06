package com.example.pet_tracker.controller;

import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.model.Pet;
import com.example.pet_tracker.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    
    // Adds a new Dog entry to the system
    @PostMapping("/dog")
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog) {
        return ResponseEntity.ok((Dog) petService.savePet(dog));
    }
    
    // Adds a new Cat, must include 'lostTracker' field
    @PostMapping("/cat")
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        return ResponseEntity.ok((Cat) petService.savePet(cat));
    }
    
    //Retrieves all pets stored in the system.
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }
    
    // Groups all out-of-zone pets by type and tracker size
    @GetMapping("/out-of-zone")
    public ResponseEntity<Map<String, Long>> getOutOfZoneGrouped() {
        return ResponseEntity.ok(petService.getOutOfZoneGroupedCounts());
    }
}
