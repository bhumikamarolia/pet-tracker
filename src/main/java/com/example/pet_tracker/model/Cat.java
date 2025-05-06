package com.example.pet_tracker.model;

import javax.persistence.*;
/**
 * Entity class representing a Cat, which is a type of Pet.
 * Includes an additional field 'lostTracker' to indicate if the cat's tracker is lost.
 */
@Entity
@DiscriminatorValue("CAT") // Identifies Cat records in the single table inheritance strategy
public class Cat extends Pet {

    @Column(nullable = true) // Can be null for Dog rows in the shared table
    private Boolean lostTracker;
    
     /**
     * Default constructor required by JPA.
     */
    public Cat() {
        super();
    }
    
    /**
     * Constructs a Cat with all necessary fields.
     *
     * @param trackerType  the type of tracker (e.g., SMALL, MEDIUM)
     * @param ownerId      the owner's ID
     * @param inZone       whether the cat is in the designated zone
     * @param lostTracker  whether the cat's tracker is lost
     */
    public Cat(String trackerType, Integer ownerId, Boolean inZone, Boolean lostTracker) {
        super(trackerType, ownerId, inZone);
        this.lostTracker = lostTracker;
    }

    public Boolean getLostTracker() {
        return lostTracker;
    }

    public void setLostTracker(Boolean lostTracker) {
        this.lostTracker = lostTracker;
    }
}
