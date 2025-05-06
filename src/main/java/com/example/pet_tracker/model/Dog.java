package com.example.pet_tracker.model;

import javax.persistence.*;
/**
 * Entity class representing a Dog, which is a type of Pet.
 */
@Entity
@DiscriminatorValue("DOG") // Specifies the discriminator value used for this subclass in single-table inheritance
public class Dog extends Pet {

    public Dog() {
        super();
    }
    
    /**
     * Constructs a Dog with all necessary fields.
     *
     * @param trackerType  the type of tracker (e.g., SMALL, MEDIUM)
     * @param ownerId      the owner's ID
     * @param inZone       whether the cat is in the designated zone
     */
    public Dog(String trackerType, Integer ownerId, Boolean inZone) {
        super(trackerType, ownerId, inZone);
    }
}
