package com.example.pet_tracker.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DOG")
public class Dog extends Pet {

    public Dog() {
        super();
    }

    public Dog(String trackerType, Integer ownerId, Boolean inZone) {
        super(trackerType, ownerId, inZone);
    }
}
