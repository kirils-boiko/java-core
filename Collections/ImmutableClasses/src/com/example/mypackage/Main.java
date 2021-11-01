package com.example.mypackage;

/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private static Map<String, String> vocabulary = new HashMap<>();

    public Main() {

        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0,
                "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1,
                "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2,
                "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3,
                "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4,
                "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5,
                "You are in the forest", tempExit));

    }

    public static void main(String[] args) {
        Main main = new Main();
        main.command();
    }

    public void command() {

        Scanner scanner = new Scanner(System.in);

        int currentLocation = 1;
        while (true) {
            System.out.println();
            System.out.println(locations.get(currentLocation).getDescription());
            if (currentLocation == 0)
                return;

            Map<String, Integer> currentExits = locations.get(currentLocation).getExits();

            System.out.println();
            System.out.print("Available exits are ");
            for (String key : currentExits.keySet()) {
                System.out.print(key + ", ");
            }
            System.out.println();
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] directionWords = direction.split(" ");
                for (String word : directionWords) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (!currentExits.containsKey(direction)) {
                System.out.println("You cannot go in that direction");
                continue;
            }

            currentLocation = currentExits.get(direction);
        }
    }
}