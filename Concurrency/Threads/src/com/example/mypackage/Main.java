package com.example.mypackage;

// Simple console application using multiple threads

public class Main {

    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_CYAN + "Hello from the " + Thread.currentThread().getName());
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another Thread");
        anotherThread.start();

        System.out.println(ThreadColor.ANSI_CYAN + "Hello again from the " + Thread.currentThread().getName());

        // Creating another thread using anonymous class
        new Thread() {
            private String name = "Anonymous Thread";

            public void run() {
                System.out.println(ThreadColor.ANSI_PURPLE + "Hello from the " + name);
            }
        }.start();

        // Creating another thread using the Runnable interface
        Thread myRunnableThread = new Thread(new MyRunnable("MyRunnable Implementation Thread"));
        myRunnableThread.start();

        //anotherThread.interrupt();

        // Creating another thread using the anonymous class and Runnable interface
        new Thread(new Runnable() {
            private String name = "Anonymous Runnable Implementation Thread";

            @Override
            public void run() {

                System.out.println(ThreadColor.ANSI_GREEN +
                        "Hello from the " + name);
                try {
                    anotherThread.join();
                    System.out.println(ThreadColor.ANSI_GREEN + "Waited till " + anotherThread.getName() +
                            " has terminated;");
                    System.out.println(name + " is up and running");
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_GREEN +
                            "I couldn't wait for " + anotherThread.getName() + " to terminate." +
                            "I was interrupted");
                }
            }
        }).start();

        try {
            anotherThread.join(2000);
            System.out.println(ThreadColor.ANSI_CYAN + "Waited till " + anotherThread.getName() +
                    " has terminated or timed out;");
            System.out.println("Hello once again from " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }

    }
}
