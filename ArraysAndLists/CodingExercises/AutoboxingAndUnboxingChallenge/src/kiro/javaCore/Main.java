package kiro.javaCore;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("IBS - International Banking Services");

    public static void main(String[] args) {

        boolean quit = false;
        printOpeningStatement();
        printInstructions();
        while(!quit) {
            System.out.println("\nEnter your choice:");
            if (!scanner.hasNextInt()) {
                System.out.println("error: choice must be numerical");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addNewBranch();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    addNewTransaction();
                    break;
                case 4:
                    listCustomers();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("error: choice must be between 1 and 5");
                    break;
            }

        }
    }

    private static void printOpeningStatement() {
        System.out.println("Welcome to " + bank.getName() + ".");
    }

    private static void printInstructions() {
        System.out.println("Press:");
        System.out.println("\t0 - to print instructions.");
        System.out.println("\t1 - to add new branch.");
        System.out.println("\t2 - to add new customer to existing branch.");
        System.out.println("\t3 - to add transaction for existing customer.");
        System.out.println("\t4 - to list customers for existing branch.");
        System.out.println("\t5 - to quit.");
    }

    private static void addNewBranch() {
        System.out.println("Enter new branch name: ");
        String branchName = scanner.nextLine();

        if (bank.addNewBranch(branchName)) {
            System.out.println("Branch " + branchName + " added successfully");
            return;
        }

        System.out.println("Branch " + branchName + " not added");
    }

    private static void addNewCustomer() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();

        System.out.println("Enter new customer name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter new customer initial transaction amount: ");
        double transactionAmount = readTransactionAmount();

        if (bank.addNewCustomer(branchName, customerName, transactionAmount)) {
            System.out.println("Customer " + customerName + " successfully added to " +
                    branchName + "; initial transaction amount: " + transactionAmount);
            return;
        }

        System.out.println("Customer " + customerName + " not added");
    }

    private static void addNewTransaction() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();

        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter transaction amount: ");
        double transactionAmount = readTransactionAmount();

        if (bank.addNewTransaction(branchName, customerName, transactionAmount)) {
            System.out.println("Transaction successfully added for customer " +
                    customerName + " in " + branchName +
                    "; transaction amount: " + transactionAmount);
            return;
        }

        System.out.println("Transaction for " + customerName + " not added");
    }

    private static void listCustomers() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();

        boolean includeTransactions;
        while(true) {
            System.out.println("Include customer transactions (y/n):");
            String response = scanner.nextLine();
            if (response.equals("y") || response.equals("n")) {
                includeTransactions = response.equals("y");
                break;
            }
            System.out.println("error: response must be \'y\' or \'n\'");
        }

        bank.listCustomers(branchName, includeTransactions);
    }

    private static double readTransactionAmount() {
        while (true) {
            if (!scanner.hasNextDouble()) {
                System.out.println("error: transaction amount must be a numerical value");
                scanner.nextLine();
                continue;
            }
            break;
        }
        double transactionAmount = scanner.nextDouble();
        return transactionAmount;
    }

}
