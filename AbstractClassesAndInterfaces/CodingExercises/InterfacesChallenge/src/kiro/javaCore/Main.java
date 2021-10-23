package kiro.javaCore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ISaveable getrekt333 = new Player("getrekt333", 100, 90, "War Hammer");
        System.out.println(getrekt333.toString());
        saveObject(getrekt333);

        ISaveable newPlayer = new Player("", -1, -1, "");
        System.out.println(newPlayer);
        writeObject(newPlayer);
        saveObject(newPlayer);

        ISaveable baseMonster = new Monster("zombie", 20, 10);
        System.out.println(baseMonster);
        saveObject(baseMonster);

        ISaveable advancedMonster = new Monster("", -1, -1);
        writeObject(advancedMonster);
        System.out.println(advancedMonster);
        saveObject(advancedMonster);


    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 - to enter a string\n" +
                "0 - to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }

        return values;
    }

    public static void saveObject(ISaveable object) {
        for (int i = 0; i < object.read().size(); i++) {
            System.out.println("Saving " + object.read().get(i) + " to storage device");
        }
    }

    public static void writeObject(ISaveable object) {
        ArrayList<String> values = readValues();
        object.write(values);
    }
}
