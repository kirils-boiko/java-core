package kiro.javaCore;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransactionAmount) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(initialTransactionAmount);
    }

    public void addTransaction(double amount) {
        transactions.add(amount);
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }
}
