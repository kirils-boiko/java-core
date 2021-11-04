package com.example.mypackage;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    //=========================================================
    // Writing locations and exits to custom files in binary format
    public static void main(String[] args) throws IOException {
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("locations_binary.dat")))) {

            for (Location location : locations.values()) {
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("Writing location " + location.getLocationID() +
                        ": " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) +
                        " exits");
                locFile.writeInt(location.getExits().size() - 1);
                for (Map.Entry<String, Integer> exit : location.getExits().entrySet()) {
                    if (!exit.getKey().equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" +exit.getKey() + "," + exit.getValue());
                        locFile.writeUTF(exit.getKey());
                        locFile.writeInt(exit.getValue());
                    }
                }
            }
        }
    }


    //=========================================================
    // Reading locations and exits from custom files in binary representation
    static {

        try(DataInputStream locFile = new DataInputStream(
                new BufferedInputStream(new FileInputStream("locations_binary.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locID = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();
                    System.out.println("Read location " + locID + ": " + description);
                    System.out.println("Found " + numExits + " exits");
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();
                        exits.put(direction, destination);
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    locations.put(locID, new Location(locID, description, exits));
                } catch (EOFException e) {
                    System.out.println("EOF reached");
                    System.out.println("==============================================");
                    eof = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (BufferedReader locationBuffer = new BufferedReader(new FileReader("locations_big.txt"));
//            BufferedReader directionBuffer = new BufferedReader(new FileReader("directions_big.txt"))) {
//
//            // reading locations
//            String line;
//            while ((line = locationBuffer.readLine()) != null) {
//                String[] input = line.split(",", 2);
//                int locationID = Integer.parseInt(input[0]);
//                String description = input[1];
//                Map<String, Integer> tempExits = new HashMap<>();
//                Location location = new Location(locationID, description, tempExits);
//                locations.put(locationID, location);
//            }
//
//            // reading exits
//            while ((line = directionBuffer.readLine()) != null) {
//                String[] input = line.split(",");
//                int locationID = Integer.parseInt(input[0]);
//                String direction = input[1];
//                int destination = Integer.parseInt(input[2]);
//                Location location = locations.get(locationID);
//                if (location != null) {
//                    location.addExit(direction, destination);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
