package com.example.mypackage.synchronization;

/*
    The thread safety is achieved using synchronization;
    For an improved version of a class using java.util.Concurrent,
        see MyProducerImproved
 */

import com.example.mypackage.Main;

import java.util.List;
import java.util.Random;

public class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5" };

        for (String num : nums) {
            try {
                synchronized (buffer) {
                    System.out.println(color + "Adding..." + num);
                    buffer.add(num);
                }

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        synchronized (buffer) {
            System.out.println(color + "Adding EOF and exiting...");
            buffer.add(Main.EOF);
        }
    }
}
