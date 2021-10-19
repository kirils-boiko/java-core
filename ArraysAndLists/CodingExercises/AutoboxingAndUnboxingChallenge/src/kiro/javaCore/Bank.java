package kiro.javaCore;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) != null) {
            System.out.println("error: branch " + branchName + " already exists;");
            return false;
        }

        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialTransactionAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("error: branch " + branchName + " not found;");
            return false;
        }

        return branch.addNewCustomer(customerName, initialTransactionAmount);
    }

    public boolean addNewTransaction(String branchName, String customerName, double transactionAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("error: branch " + branchName + " not found;");
            return false;
        }

        return branch.addTransaction(customerName, transactionAmount);
    }

    public void listCustomers(String branchName, boolean includeTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("error: branch " + branchName + " not found;");
        }

        branch.listCustomers(includeTransactions);
    }

    public String getName() {
        return name;
    }

    private Branch findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branchName))
                return branches.get(i);
        }
        return null;
    }
}
