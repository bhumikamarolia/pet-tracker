package com.example.pet_tracker.dto;

public class PetResponseDTO {
    private Long id;
    private String trackerType;
    private Integer ownerId;
    private Boolean inZone;
    private String petType;

    public PetResponseDTO() {}

    public PetResponseDTO(Long id, String trackerType, Integer ownerId, Boolean inZone, String petType) {
        this.id = id;
        this.trackerType = trackerType;
        this.ownerId = ownerId;
        this.inZone = inZone;
        this.petType = petType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTrackerType() { return trackerType; }
    public void setTrackerType(String trackerType) { this.trackerType = trackerType; }

    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public Boolean getInZone() { return inZone; }
    public void setInZone(Boolean inZone) { this.inZone = inZone; }

    public String getPetType() { return petType; }
    public void setPetType(String petType) { this.petType = petType; }
}
