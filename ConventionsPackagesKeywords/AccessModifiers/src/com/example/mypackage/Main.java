package com.example.mypackage;

public class Main {

    public static void main(String[] args) {

        Account myAccount = new Account("Example");
        myAccount.deposit(1000);
        myAccount.withdraw(500);
        myAccount.withdraw(-599);
        myAccount.deposit(-20);
        myAccount.calculateBalance();

        // should not be exposed directly
//        myAccount.balance = 5000;
//        myAccount.transactions.add(4500);

        System.out.println("Balance on account is " + myAccount.getBalance());
    }
}
