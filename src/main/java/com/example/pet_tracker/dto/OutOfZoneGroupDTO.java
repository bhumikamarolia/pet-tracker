package com.example.pet_tracker.dto;

public class OutOfZoneGroupDTO {

    private String group;
    private Long count;

    public OutOfZoneGroupDTO() {}

    public OutOfZoneGroupDTO(String group, Long count) {
        this.group = group;
        this.count = count;
    }

    // Getters and Setters
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}
