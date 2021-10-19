package kiro.javaCore;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) {
            System.out.println("error: branch " + branchName + " already exists;");
            return false;
        }

        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransactionAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("error: branch " + branchName + " not found;");
            return false;
        }

        return branch.newCustomer(customerName, initialTransactionAmount);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("error: branch " + branchName + " not found;");
            return false;
        }

        return branch.addCustomerTransaction(customerName, transactionAmount);
    }

    public boolean listCustomers(String branchName, boolean includeTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            //System.out.println("error: branch " + branchName + " not found;");
            return false;
        }

        System.out.println("Customer details for branch " + branchName);
        for (int i = 0; i < branch.getCustomers().size(); i++) {
            System.out.println(String.format("Customer: %s[%d]",
                    branch.getCustomers().get(i).getName(), i + 1));
            if (includeTransactions) {
                System.out.println("Transactions");
                for (int j = 0;
                     j < branch.getCustomers().get(i).getTransactions().size(); j++) {
                    System.out.println(String.format("[%d]  Amount %.2f",
                            j+1, branch.getCustomers().get(i).getTransactions().get(j)));
                }
            }
        }
        return true;

    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName))
                return branches.get(i);
        }
        return null;
    }
}

