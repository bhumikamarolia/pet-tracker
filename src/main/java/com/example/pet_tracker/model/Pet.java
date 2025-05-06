package com.example.pet_tracker.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pet_type")
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String trackerType;

    @Column(nullable = false)
    private Integer ownerId;

    @Column(nullable = false)
    private Boolean inZone;

    public Pet() {}

    public Pet(String trackerType, Integer ownerId, Boolean inZone) {
        this.trackerType = trackerType;
        this.ownerId = ownerId;
        this.inZone = inZone;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public String getTrackerType() { return trackerType; }

    public void setTrackerType(String trackerType) { this.trackerType = trackerType; }

    public Integer getOwnerId() { return ownerId; }

    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public Boolean getInZone() { return inZone; }

    public void setInZone(Boolean inZone) { this.inZone = inZone; }
}
