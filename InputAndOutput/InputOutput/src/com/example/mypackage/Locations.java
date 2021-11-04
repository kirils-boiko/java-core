package com.example.mypackage;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    //=========================================================
    // Writing locations and exits to custom files
    public static void main(String[] args) throws IOException {

        try (BufferedWriter locationBuffer = new BufferedWriter(new FileWriter("locations_custom.txt"));
            BufferedWriter directionBuffer = new BufferedWriter(new FileWriter("directions_custom.txt"))) {

            // writing locations and exits
            for (Location location : locations.values()) {
                locationBuffer.write(location.getLocationID() + "," +
                        location.getDescription() + "\n");

                for (Map.Entry<String, Integer> exit : location.getExits().entrySet()) {
                    if (exit.getValue() != 0) {
                        directionBuffer.write(location.getLocationID() + "," +
                                exit.getKey() + "," + exit.getValue() + "\n");
                    }
                }
            }
        }

    }


    //=========================================================
    // Reading locations and exits from custom files using
    static {

        try (BufferedReader locationBuffer = new BufferedReader(new FileReader("locations_big.txt"));
            BufferedReader directionBuffer = new BufferedReader(new FileReader("directions_big.txt"))) {

            // reading locations
            String line;
            while ((line = locationBuffer.readLine()) != null) {
                String[] input = line.split(",", 2);
                int locationID = Integer.parseInt(input[0]);
                String description = input[1];
                Map<String, Integer> tempExits = new HashMap<>();
                Location location = new Location(locationID, description, tempExits);
                locations.put(locationID, location);
            }

            // reading exits
            while ((line = directionBuffer.readLine()) != null) {
                String[] input = line.split(",");
                int locationID = Integer.parseInt(input[0]);
                String direction = input[1];
                int destination = Integer.parseInt(input[2]);
                Location location = locations.get(locationID);
                if (location != null) {
                    location.addExit(direction, destination);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //=========================================================
    // Implementing the Map interface

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
