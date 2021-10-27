package kiro.javaCore;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
    }

    public boolean addNewTransaction(double amount) {
        if (amount == 0.0) {
            System.out.println("error: transaction amount cannot be zero");
            return false;
        }
        transactions.add(amount);
        return true;
    }

    public void listTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(String.format("\t%.2f", transactions.get(i)));
        }
    }

    public String getName() {
        return name;
    }
}
