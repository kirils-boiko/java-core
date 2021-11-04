package com.example.mypackage;

import java.io.*;
import java.util.*;

// 1. The first four bytes of the file will contain the number of locations (0-3)
// 2. The next four bytes will contain the start offset of the location section (bytes 4- 7)
// 3. The next section of the file will contain the index (the index if 1692 bytes long; bytes 8 - 1699)
// 4. The final section contains the location records (data) (starts at byte 1700)

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    //=========================================================
    // Writing locations and exits to custom files using RandomAccessFile
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat",
                "rwd")) {
            rao.writeInt(locations.size()); // number of locations
            int indexSize = locations.size() * 3 * Integer.BYTES;   // index storing locID, offset, recordLength
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);

            // build the index in memory as you write the locations starting from locationStart
            long indexStart = rao.getFilePointer();     // to save the starting byte position for index

            int startPointer = locationStart;
            rao.seek(startPointer);     // move the file pointer

            for (Location location : locations.values()) {
                rao.writeInt(location.getLocationID());
                rao.writeUTF(location.getDescription());
                StringBuilder builder = new StringBuilder();
                for (Map.Entry<String, Integer> exit : location.getExits().entrySet()) {
                    if (!exit.getKey().equalsIgnoreCase("Q")) {
                        builder.append(exit.getKey());
                        builder.append(",");
                        builder.append(exit.getValue());
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());

                IndexRecord record = new IndexRecord(startPointer,
                        (int) (rao.getFilePointer() - startPointer));
                index.put(location.getLocationID(), record);

                startPointer = (int) rao.getFilePointer();
            }

            // write the index to file starting from indexStart position (right after first two bytes)
            rao.seek(indexStart);
            for (Map.Entry<Integer, IndexRecord> record : index.entrySet()) {
                rao.writeInt(record.getKey());
                rao.writeInt(record.getValue().getStartByte());
                rao.writeInt(record.getValue().getRecordLength());
            }
        }
    }


    //=========================================================
    // Reading locations and exits from locations_rand.dat create from Locations.main() method before
    // Note if you would need to call the main method again, you would first need
    //  to load the locations from the old project in static block initializer first,
    //  then comment out the current static initializer which is reading from locations_rand.dat
    //  run the main method with the old static block initializer (locations_object_binary.dat)
    static {
        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd");
            int numLocations = ra.readInt();
            long locationStartPoint = ra.readInt();

            while (ra.getFilePointer() < locationStartPoint) {
                int locationID = ra.readInt();
                int locationStartByte = ra.readInt();
                int locationLength = ra.readInt();

                IndexRecord record = new IndexRecord(locationStartByte, locationLength);
                index.put(locationID, record);
            }

        } catch (IOException e) {
            System.out.println("IOException in Locations static initializer:" +
                    e.getMessage());
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        ra.close();
    }

    public Location getLocation(int locationID) throws IOException {

        IndexRecord record = index.get(locationID);
        ra.seek(record.getStartByte());

        int id = ra.readInt();
        String description = ra.readUTF();

        String exits = ra.readUTF();
        String[] exitPart = exits.split(",");

        Location toReturn = new Location(locationID, description, null);
        if (locationID != 0) {
            for (int i = 0; i < exitPart.length - 1; i += 2) {
                // add exits from exitPart string array;
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                toReturn.addExit(exitPart[i], Integer.parseInt(exitPart[i + 1]));
            }
        }

        return toReturn;
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




//=======================================================
// Old static block initializer for getting data for the first-time call of
//  Locations.main() method;

//
//      static {
//
//        try(ObjectInputStream locFile = new ObjectInputStream(
//                new BufferedInputStream(new FileInputStream("locations_object_binary.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() +
//                            ": " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() +
//                            " exits");
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    System.out.println("EOF reached");
//                    System.out.println("=======================================");
//                    eof = true;
//                }
//            }
//        } catch (InvalidClassException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
