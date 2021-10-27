package kiro.javaCore;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public boolean newCustomer(String customerName, double initialTransactionAmount) {

        if (findCustomer(customerName) != null) {
            System.out.println("error: customer " + customerName + " already exists");
            return false;
        }

        if (initialTransactionAmount <= 0.0) {
            System.out.println("error: transaction amount must be positive");
            return false;
        }

        customers.add(new Customer(customerName, initialTransactionAmount));
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount) {
        Customer customer = findCustomer(customerName);
        if (customer == null) {
            System.out.println("error: customer " + customerName + " not found");
            return false;
        }

        if (transactionAmount <= 0.0) {
            System.out.println("error: transaction amount must be positive");
            return false;
        }

        customer.addTransaction(transactionAmount);
        return true;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }
}
