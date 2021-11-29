package com.example.mypackage.synchronization;

/*
    The thread safety is achieved using synchronization;
    For an improved version of a class using java.util.Concurrent,
        see MyConsumerImproved
 */


import com.example.mypackage.Main;

import java.util.List;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }

                if (buffer.get(0).equals(Main.EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }
}
