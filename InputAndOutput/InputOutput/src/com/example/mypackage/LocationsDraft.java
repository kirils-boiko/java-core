package com.example.mypackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LocationsDraft implements Map<Integer, Location> {

    // This draft includes all the commented out sections
    // For a clean version of Locations class see Locations


    private static Map<Integer, Location> locations = new HashMap<>();

    //=========================================================
    // Writing locations and exits to custom files
    public static void main(String[] args) throws IOException {

//        //---------------------------------------------
//        // Writing to a file (without specifying the throwing)
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ": " + location.getDescription() + "\n");
//            }
//        } catch (IOException e) {
//            System.out.println("In catch block");
//            e.printStackTrace();
//        } finally {
//            System.out.println("In finally block");
//            try {
//                if (locFile != null) {
//                    System.out.println("Attempting to close locFile");
//                    locFile.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//      //---------------------------------------------
//      // Writing to a file (with specifying the throwing)
//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ": " + location.getDescription() + "\n");
//                // throw new IOException("test exception thrown while writing");
//            }
//        } finally {
//            System.out.println("In finally block");
//            if (locFile != null) {
//                System.out.println("Attempting to close locFile");
//                locFile.close();
//            }
//        }


        //--------------------------------------------
        // try-with-resources for writing files with locations and exits
        //  note: for that you need to initialize the locations and exits
        //  first in the static block;

//        try (FileWriter locFile = new FileWriter("locations.txt");
//            FileWriter exitFile = new FileWriter("exits.txt")) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ":" +
//                        location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    exitFile.write(location.getLocationID() + ":" +
//                            direction + ":" + location.getExits().get(direction) + "\n");
//                }
//            }
//        }
    }


    //=========================================================
    // Reading locations and exits from custom files
    static {

//        Map<String, Integer> tempExit = new HashMap<String, Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",null));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String, Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));

        //--------------------------------------------
        // Reading locations and exits files with standard try-catch-finally block

//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileReader("locations_big.txt"));
//            scanner.useDelimiter(",");
//
//            while (scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description,tempExit));
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//           if (scanner != null)
//               scanner.close();
//        }
//
//        // Now read the exits
//        try {
//            scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")));
//            scanner.useDelimiter(":");
//
//            while (scanner.hasNextLine()) {
////                int locationID = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                String direction = scanner.next();  // gets a token until a delimiter
////                scanner.skip(scanner.delimiter());
////                String temp = scanner.nextLine();
////                int destination = Integer.parseInt(temp);
//                String[] input = scanner.nextLine().split(",");
//                int locationID = Integer.parseInt(input[0]);
//                String direction = input[1];
//                int destination = Integer.parseInt(input[2]);
//                System.out.println(locationID + ": " + direction + ": " + destination);
//                Location location = locations.get(locationID);
//                if (location != null) {
//                    location.addExit(direction, destination);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (scanner != null)
//                scanner.close();
//        }

        //--------------------------------------------
        // Reading locations and exits files with standard try-with-resources block

        try (Scanner locationScanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")));
             BufferedReader directionBuffer = new BufferedReader(new FileReader("directions_big.txt"))) {

            // reading locations
            locationScanner.useDelimiter(",");
            while (locationScanner.hasNextLine()) {
                int locationID = locationScanner.nextInt();
                locationScanner.skip(locationScanner.delimiter());
                String description = locationScanner.nextLine();
                Map<String, Integer> tempExits = new HashMap<>();
                Location location = new Location(locationID, description, tempExits);
                locations.put(locationID, location);
            }

            // reading exits
            String line;
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
    public Set<Map.Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
