package com.example.mypackage;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread1().start();
        new Thread2().start();

    }

    private static class Thread1 extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: lock1 acquired");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }

                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: lock1 and lock2 acquired");
                }
                System.out.println("Thread 1: lock2 released");
            }
            System.out.println("Thread 1: lock1 released\nExiting...");
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: lock2 acquired");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }

                System.out.println("Thread 2: waiting for lock1");
                synchronized (lock1) {
                    System.out.println("Thread 2: lock2 and lock1 acquired");
                }
                System.out.println("Thread 2: lock1 released");
            }
            System.out.println("Thread 2: lock2 released\nExiting...");
        }
    }

}


