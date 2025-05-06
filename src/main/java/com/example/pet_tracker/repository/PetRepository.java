package com.example.pet_tracker.repository;

import com.example.pet_tracker.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for accessing and managing Pet entities in the database.
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
   // Finds all pets that are currently out of zone (inZone = false).
    List<Pet> findByInZoneFalse();
}
