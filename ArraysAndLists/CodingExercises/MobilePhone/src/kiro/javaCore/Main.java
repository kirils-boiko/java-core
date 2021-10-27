package kiro.javaCore;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("2222");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        int action = 0;
        while (!quit) {
            System.out.println("\nEnter action: ");
            if (!scanner.hasNextInt()) {
                System.out.println("error: action should be a numerical value");
                scanner.nextLine();
                continue;
            }
            action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    printActions();
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                default:
                    System.out.println("error: action must be between 1 and 6");
                    break;
            }

        }
    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions: \nPress:");
        System.out.println("\t0 - to print available actions");
        System.out.println("\t1 - to print contact list");
        System.out.println("\t2 - to add a new contact");
        System.out.println("\t3 - to update an existing contact");
        System.out.println("\t4 - to remove an existing contact");
        System.out.println("\t5 - to query the contact");
        System.out.println("\t6 - to shutdown");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number for this contact:");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber);
        mobilePhone.addNewContact(newContact);
    }

    private static void updateContact() {
        System.out.println("Enter name of existing contact to update:");
        String name = scanner.nextLine();
        Contact oldContact = mobilePhone.queryContact(name);
        if (oldContact == null) {
            System.out.println("Contact " + name + " not found");
            return;
        }

        System.out.println("Enter new contact name:");
        String newName = scanner.nextLine();

        System.out.println("Enter new contact phone number:");
        String newPhoneNumber = scanner.nextLine();

        Contact newContact = new Contact(newName, newPhoneNumber);
        mobilePhone.updateContact(oldContact, newContact);

    }

    private static void removeContact() {
        System.out.println("Enter name of contact to remove:");
        String name = scanner.nextLine();

        Contact toRemove = new Contact(name, "");
        mobilePhone.removeContact(toRemove);
    }


    private static void queryContact() {
        System.out.println("Enter name of contact to query for:");
        String name = scanner.nextLine();

        Contact toQuery = mobilePhone.queryContact(name);

        if (toQuery != null) {
            System.out.println("Contact info:");
            System.out.println(toQuery.getName() + " -> " + toQuery.getPhoneNumber());
            return;
        }

        System.out.println("Contact " + name + " not found");
        return;
    }
}
