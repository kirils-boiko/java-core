package com.example.mypackage;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
	    // Challenge 1
        BankAccount account = new BankAccount(1000.00,
                "12345-678", lock);

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        }).start();


        // Challenge 2: make the BankAccount deposit() and withdraw() thread-safe

        // Challenge 3: make the updated BankAccount (with accountNumber methods)
        //  thread-safe

        // Challenge 4: use the ReentrantLock to make BankAccount thread-safe

        // Challenge 5: use the tryLock() with a timeout value of 1 second

        // Challenge 6: make the status variable thread-safe in deposit
        //  and withdraw methods

    }
}
