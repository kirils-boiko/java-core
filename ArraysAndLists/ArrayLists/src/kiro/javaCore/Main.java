package kiro.javaCore;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("\nEnter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("error: choice must be a numerical input;");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    getItem();
                    break;
                case 4:
                    modifyItem();
                    break;
                case 5:
                    removeItem();
                    break;
                case 6:
                    searchForItem();
                    break;
                case 7:
                    processArrayList();
                    break;
                case 8:
                    quit = true;
                    break;
                default:
                    System.out.println("error: choice must be a value between 1 and 8;");
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list.");
        System.out.println("\t 3 - To get an item from the list.");
        System.out.println("\t 4 - To modify  an item in the list.");
        System.out.println("\t 5 - To remove an item from the list.");
        System.out.println("\t 6 - To search for an item in the list.");
        System.out.println("\t 7 - To process the ArrayList (functionality showcase).");
        System.out.println("\t 8 - To quit the application.");
    }

    public static void printGroceryList() {
        System.out.println("You have " + groceryList.getSize() +
                " items in your grocery list:");
        for (int i = 0; i < groceryList.getSize(); i++) {
            System.out.println((i+1) + ". " + groceryList.getGroceryItem(i));
        }
    }

    public static void addItem() {
        System.out.println("Please enter the grocery item you want to add:");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void getItem() {
        System.out.println("Enter item number you want to get:");
        int itemNumber = readItemNumber();

        String item = groceryList.getGroceryItem(itemNumber - 1);
        if (item != null) {
            System.out.println("Item number " + itemNumber + ": " + item);
        }
    }

    public static void modifyItem() {

        System.out.println("Enter item name you want to modify:");
        String currentItem = readItemName();    // better practice than reading item number

        System.out.println("Enter replacement item:");
        String replacementItem = readItemName();
        groceryList.modifyGroceryItem(currentItem, replacementItem);
    }

    public static void removeItem() {

        System.out.println("Enter item name you want to remove:");
        String currentItem = readItemName();    // better practice than reading item number

        groceryList.removeGroceryItem(currentItem);
    }

    public static void searchForItem() {
        System.out.println("Enter item name to search for: ");
        String searchItem = scanner.nextLine();
        int position = groceryList.findItem(searchItem);

        if (position > 0) {
            System.out.println("Item position in the list: " + (position + 1));
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void processArrayList() {
        // just an illustration of ways to copy an ArrayList or convert
        //  it to regular array

        // 1st way of copying
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // 2nd way of copying
        ArrayList<String> nextArray = new
                ArrayList<String>(groceryList.getGroceryList());

        // converting ArrayList to Array
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }

    //-------------------------------
    // Helper Functions

    private static int readItemNumber() {
        if (scanner.hasNextInt()) {
            int itemNumber = scanner.nextInt();
            scanner.nextLine();
            return itemNumber;
        }
        return -1;
    }

    private static String readItemName() {
        if (scanner.hasNextLine()) {
            String itemName = scanner.nextLine();
            return itemName;
        }
        return null;
    }
}
