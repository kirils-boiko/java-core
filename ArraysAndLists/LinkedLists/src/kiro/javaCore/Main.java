package kiro.javaCore;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //---------------------------------------
        // how references work
        Customer customer = new Customer("John", 777.777);
        Customer anotherCustomer;
        anotherCustomer = customer; // reference instead of new object
        anotherCustomer.setBalance(12.18);  // changes the balance for customer

        System.out.println("Balance for customer " + customer.getName() +
                " is " + customer.getBalance());

        //---------------------------------------
        // LinkedLists
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Lisbon");
        placesToVisit.add("Moscow");
        placesToVisit.add("Berlin");
        placesToVisit.add("Paris");
        placesToVisit.add("London");
        placesToVisit.add("Budapest");
        placesToVisit.add("Madrid");

        printList(placesToVisit);

        placesToVisit.add(1, "Reykjavik");
        printList(placesToVisit);

        placesToVisit.remove(4);
        printList(placesToVisit);

        //-----------------------------------------
        // Illustrating the use of Iterator
        LinkedList<String> namesToConsider = new LinkedList<String>();
        namesToConsider.add("Keira");
        ListIterator<String> listIterator = namesToConsider.listIterator();
        System.out.println(listIterator.next());
        System.out.println("===================================");

        //-----------------------------------------
        // Adding elements in alphabetical order to the LinkedList
        LinkedList<String> orcNames = new LinkedList<String>();
        addInOrder(orcNames, "Thrall");
        addInOrder(orcNames, "Blackhand");
        addInOrder(orcNames, "Gul'dan");
        addInOrder(orcNames, "Durotan");
        addInOrder(orcNames, "Orgrim");
        addInOrder(orcNames, "Grommash");
        addInOrder(orcNames, "Garrosh");
        addInOrder(orcNames, "Thrall");

        printList(orcNames);


        //-----------------------------------------
        // Nagrand Arena
        fight(orcNames);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===================================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newElement) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            // comparison returns an number:
            //  0 - equal
            //  -1 - less
            //  1 - larger
            int comparison = stringListIterator.next().compareTo(newElement);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newElement + " is already included as destination");
                System.out.println("===================================");
                return false;
            } else if (comparison > 0) {
                // newCity should appear before this one
                // move back to previous entry
                stringListIterator.previous();  // iterator to previous city
                stringListIterator.add(newElement);    // add after the previous city
                return true;
            } else if (comparison < 0) {
                // move on to next city
                // nothing needs to be done since .next() already increments the iterator
            }
        }

        // went completely through the list - add city to the end
        stringListIterator.add(newElement);
        return true;
    }

    private static void fight(LinkedList<String> orcs) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = orcs.listIterator();

        System.out.println("Welcome to the Nagrand Arena!");
        if (orcs.isEmpty()) {
            System.out.println("There are no orcs to fight, you Barthilas's offspring!");
            return;
        } else {
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Fighting " + listIterator.next() + "! Let the battle begin!");
                        System.out.println("Battle's finished, you fought with honor!");
                    } else {
                        System.out.println("There are no more orcs to fight! Congratulations!");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Returned to fighting " + listIterator.previous() + "! Let the battle begin!");
                        System.out.println("Battle's finished, you fought with honor!");
                    } else {
                        System.out.println("There is no place to return now!");
                        goingForward = true;
                    }
                    break;
                case 3:
                    System.out.println("Whether you're leaving as a conqueror or as a slave, you're always welcome to come back to prove your worth!");
                    quit = true;
                    break;
            }

        }
    }

    private static void printMenu() {
        System.out.println("Press:");
        System.out.println("\t0 - to see your limited choices, human.");
        System.out.println("\t1 - to fight the next greenskin!");
        System.out.println("\t2 - to return to the previous orc!");
        System.out.println("\t3 - to leave the arena.");
    }
}
