package com.example.mypackage;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    //=========================================================
    // Writing locations and exits to custom files using serialization
    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream("locations_object_binary.dat")))) {

            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }


    //=========================================================
    // Reading locations and exits from custom files in binary representation
    static {

        try(ObjectInputStream locFile = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("locations_object_binary.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() +
                            ": " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() +
                            " exits");
                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    System.out.println("EOF reached");
                    System.out.println("=======================================");
                    eof = true;
                }
            }
        } catch (InvalidClassException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
