package com.example.mypackage;


import java.util.HashMap;
import java.util.Map;

public final class Location {
    // Immutable Location class made by:
    //  making the class final;
    //  making fields private and final;
    //  returning new objects created from existing fields from the methods;
    //  not providing setters for the fields that are not intended to be changed;
    //  set new objects from the passed objects in the constructor

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = (exits != null) ? new HashMap<>(exits) : new HashMap<>();
        this.exits.put("Q", 0);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
