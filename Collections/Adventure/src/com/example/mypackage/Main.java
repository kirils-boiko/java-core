package com.example.mypackage;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Map<String, String> directions = new HashMap<>();

    public static void main(String[] args) {

        directions.put("NORTH", "N");
        directions.put("SOUTH", "S");
        directions.put("WEST", "W");
        directions.put("EAST", "E");
        directions.put("QUIT", "Q");


        locations.put(-1, new Location(-1,"Deserter Lands"));
        locations.put(0, new Location(0,"Safe Lands"));
        locations.put(1, new Location(1,"Ruins of Stormwind"));
        locations.put(2, new Location(2,"Ironforge"));
        locations.put(3, new Location(3,"Southshore"));
        locations.put(4, new Location(4,"Alterac"));
        locations.put(5, new Location(5,"Aerie Peak"));
        locations.put(6, new Location(6,"Dalaran"));
        locations.put(7, new Location(7,"Lordaeron"));

        // adding exits
        locations.get(1).addExit("N", 2);   // for Stormwind
        locations.get(2).addExit("N", 3);   // for Ironforge
        locations.get(3).addExit("N", 4);   // for Southshore
        locations.get(3).addExit("S", 2);
        locations.get(3).addExit("W", 6);
        locations.get(4).addExit("S", 3);   // for Alterac
        locations.get(4).addExit("W", 6);
        locations.get(4).addExit("E", 5);
        locations.get(5).addExit("W", 4);   // for Aerie Peak
        locations.get(5).addExit("N", 3);
        locations.get(6).addExit("N", 7);   // for Dalaran
        locations.get(6).addExit("S", 3);
        locations.get(6).addExit("E", 4);
        locations.get(7).addExit("N", 0);   // for Lordaeron
        locations.get(7).addExit("S", 4);
        locations.get(7).addExit("W", 6);

        printLocations(locations);
        playGame();


    }

    private static void printLocations(Map<Integer, Location> locations) {
        System.out.println("\n=============================================");
        for (Integer key : locations.keySet()) {
            System.out.println("#" + key + ": " + locations.get(key).getDescription());
        }
        System.out.println("=============================================\n");
    }

    private static void printInstructions() {
        System.out.println();
        System.out.println("Welcome to the World of Warcraft Adventure Game: Tides of Darkness Edition");
        System.out.println("The dark and difficult times have come...");
        System.out.println("The mighty Stormwind had fallen...");
        System.out.println("You are the last standing descendant of Arathi bloodline!");
        System.out.println("Your goal is to get to the Safe Lands to rule the Azeroth once again in the future!");
        System.out.println("Potential directions to go to: ");
        System.out.println("\tN - North");
        System.out.println("\tS - South");
        System.out.println("\tW - West");
        System.out.println("\tE - East");
        System.out.println("\tQ - Quit");

    }

    private static void playGame() {
        printInstructions();
        int currentLocation = 1;
        while(true) {
            System.out.println("Current location: " +
                    locations.get(currentLocation).getDescription());
            if (currentLocation == -1) {
                System.out.println("You are a shame to the Arathi bloodline!");
                System.out.println("Quitting the game...");
                break;
            }

            if (currentLocation == 0) {
                System.out.println("Congratulations, you have made it to the Safe Lands!");
                System.out.println("May the Arathi rule forever!");
                break;
            }

            Map<String, Integer> currentExits = locations.get(currentLocation).getExits();

            System.out.println("Enter direction you want to go to: ");
            String direction = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                String[] directionWords = direction.split(" ");
                for (String word : directionWords) {
                    String directionLetter = directions.get(word);
                    if (directionLetter != null) {
                        direction = directionLetter;
                        break;
                    }
                    if (currentExits.containsKey(word)) {
                        direction = word;
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
