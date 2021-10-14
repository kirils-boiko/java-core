package kiro.javaCore;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("\nEnter your choice:");
            if (!scanner.hasNextInt()) {
                System.out.println("error: choice must be a numerical value");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContactName();
                    break;
                case 4:
                    modifyContactPhoneNumber();
                    break;
                case 5:
                    removeContact();
                    break;
                case 6:
                    searchContact();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("error: choice must be between 1 and 7");
                    break;
            }
        }
    }

    private static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a contact.");
        System.out.println("\t 3 - To modify the contact name.");
        System.out.println("\t 4 - To modify the contact phone number.");
        System.out.println("\t 5 - To remove a contact.");
        System.out.println("\t 6 - To search for a contact.");
        System.out.println("\t 7 - To quit the application.");
    }

    private static void printContacts() {
        System.out.println("\nContact list:");
        if (mobilePhone.getSize() == 0)
            System.out.println("Empty");
        for (int i = 0; i < mobilePhone.getSize(); i++) {
            System.out.println();
            Contact toPrint = mobilePhone.getContact(i);
            System.out.println("Name: " + toPrint.getName());
            System.out.println("Phone number: " + toPrint.getPhoneNumber());
        }
    }

    private static void addContact() {
        System.out.println("\nPlease enter name for a new contact:");
        scanner.nextLine();
        String name = readString();

        System.out.println("Please enter phone number for a new contact:");
        String phoneNumber = readString();

        mobilePhone.storeContact(name, phoneNumber);
    }

    private static void modifyContactName() {
        System.out.println("\nPlease enter name of a contact you want to modify:");
        scanner.nextLine();
        String name = readString();

        System.out.println("Please enter new name for this contact:");
        String newName = readString();

        mobilePhone.modifyContactName(name, newName);
    }

    private static void modifyContactPhoneNumber() {
        System.out.println("\nPlease enter name of a contact you want to modify:");
        scanner.nextLine();
        String name = readString();

        System.out.println("Please enter new phone number for this contact:");
        String newPhoneNumber = readString();

        mobilePhone.modifyContactNumber(name, newPhoneNumber);
    }

    private static void removeContact() {
        System.out.println("\nPlease enter name of a contact you want to remove:");
        scanner.nextLine();
        String name = readString();

        mobilePhone.removeContact(name);
    }

    private static void searchContact() {
        System.out.println("\nPlease enter name of a contact you want to search for:");
        scanner.nextLine();
        String name = readString();

        Contact toSearch = mobilePhone.findContact(name);
        if (toSearch != null) {
            System.out.println("\nContact info:");
            System.out.println("Name: " + toSearch.getName());
            System.out.println("Phone number: " + toSearch.getPhoneNumber());
            return;
        }
        System.out.println("Contact \"" + name + "\" is not in the list");

    }

    private static String readString() {
        if (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            return string;
        }
        return null;
    }
}
