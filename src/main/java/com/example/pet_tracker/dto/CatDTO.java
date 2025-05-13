package com.example.pet_tracker.dto;

import javax.validation.constraints.NotNull;

public class CatDTO {

    @NotNull
    private String trackerType;

    @NotNull
    private Integer ownerId;

    @NotNull
    private Boolean inZone;

    @NotNull(message = "Field 'lostTracker' must not be null")
    private Boolean lostTracker;

    // Getters and setters
    public String getTrackerType() { return trackerType; }
    public void setTrackerType(String trackerType) { this.trackerType = trackerType; }

    public Integer getOwnerId() { return ownerId; }
    public void setOwnerId(Integer ownerId) { this.ownerId = ownerId; }

    public Boolean getInZone() { return inZone; }
    public void setInZone(Boolean inZone) { this.inZone = inZone; }

    public Boolean getLostTracker() { return lostTracker; }
    public void setLostTracker(Boolean lostTracker) { this.lostTracker = lostTracker; }
}
