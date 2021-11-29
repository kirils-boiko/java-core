package com.example.mypackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accountNumber;
    private ReentrantLock lock;

    public BankAccount(double initialBalance, String accountNumber,
                       ReentrantLock lock) {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
        this.lock = lock;

    }

    public void deposit(double amount) {
//        synchronized (this) {
//            balance += amount;
//        }

//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }

        boolean status = false;
        try {
          if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            try {
                balance += amount;
                status = true;
            } finally {
                lock.unlock();
            }
          } else {
              System.out.println("Thread " + Thread.currentThread().getName() +
                      " could not get the lock");
          }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() +
                    " was interrupted");
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }

//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }

        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Thread " + Thread.currentThread().getName() +
                        " could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() +
                    " was interrupted");
        }

        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
