package com.example.pet_tracker.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CAT")
public class Cat extends Pet {

    @Column(nullable = true)
    private Boolean lostTracker;

    public Cat() {
        super();
    }

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
