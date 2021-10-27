package kiro.javaCore;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public boolean addNewCustomer(String customerName, double initialTransactionAmount) {

        if (findCustomer(customerName) != null) {
            System.out.println("error: customer " + customerName + " already exists");
            return false;
        }

        Customer customer = new Customer(customerName);
        if (customer.addNewTransaction(initialTransactionAmount)) {
            customers.add(customer);
            return true;
        }

        return false;
    }

    public boolean addTransaction(String customerName, double transactionAmount) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("error: customer " + customerName + " not found");
            return false;
        }

        return customer.addNewTransaction(transactionAmount);
    }

    public void listCustomers(boolean includeTransactions) {
        System.out.print("Customer list");
        if (includeTransactions)
            System.out.print(" with their transactions");
        System.out.print(":\n");
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("Customer #" + (i+1) + " | Name: " + customer.getName());
            if (includeTransactions)
                customer.listTransactions();
        }
    }

    public String getName() {
        return name;
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }
}
