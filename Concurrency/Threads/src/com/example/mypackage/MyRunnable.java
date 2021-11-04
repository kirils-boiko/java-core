package com.example.mypackage;

public class MyRunnable implements Runnable {

    private final String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_RED + "Hello from " + name);
    }
}
