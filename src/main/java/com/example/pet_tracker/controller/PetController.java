package com.example.pet_tracker.controller;

import com.example.pet_tracker.dto.CatDTO;
import com.example.pet_tracker.dto.DogDTO;
import com.example.pet_tracker.dto.OutOfZoneGroupDTO;
import com.example.pet_tracker.dto.PetResponseDTO;
import com.example.pet_tracker.model.Cat;
import com.example.pet_tracker.model.Dog;
import com.example.pet_tracker.model.Pet;
import com.example.pet_tracker.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }
    
    // Adds a new Dog entry to the system
    @PostMapping("/dog")
    public ResponseEntity<PetResponseDTO> addDog(@Valid @RequestBody DogDTO dogDTO) {
        Dog dog = petService.mapToDogEntity(dogDTO);
        Pet saved = petService.savePet(dog);
        return ResponseEntity.ok(petService.mapToResponse(saved));
    }
    
    // Adds a new Cat, must include 'lostTracker' field
    @PostMapping("/cat")
    public ResponseEntity<PetResponseDTO> addCat(@Valid @RequestBody CatDTO catDTO) {
        Cat cat = petService.mapToCatEntity(catDTO);
        Pet saved = petService.savePet(cat);
        return ResponseEntity.ok(petService.mapToResponse(saved));
    }
    
    //Retrieves all pets stored in the system.
    @GetMapping
    public ResponseEntity<List<PetResponseDTO>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        List<PetResponseDTO> response = pets.stream()
            .map(petService::mapToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
    // Groups all out-of-zone pets by type and tracker size
    @GetMapping("/out-of-zone")
    public ResponseEntity<List<OutOfZoneGroupDTO>> getOutOfZoneGrouped() {
    Map<String, Long> rawMap = petService.getOutOfZoneGroupedCounts();
    List<OutOfZoneGroupDTO> response = rawMap.entrySet().stream()
        .map(entry -> new OutOfZoneGroupDTO(entry.getKey(), entry.getValue()))
        .collect(Collectors.toList());
    return ResponseEntity.ok(response);
    }
    
}
