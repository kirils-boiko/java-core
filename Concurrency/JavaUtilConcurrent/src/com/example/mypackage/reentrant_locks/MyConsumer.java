package com.example.mypackage.reentrant_locks;

/*
    The thread safety is achieved using java.util.concurrent and
    reentrant intrinsic locks;
 */

import com.example.mypackage.Main;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {

        int counter = 0;

        while(true) {
            try {
                if (bufferLock.tryLock(100, TimeUnit.NANOSECONDS)) { // tryLock() checks and acquires the lock if it's available
                    try {
                        if (buffer.isEmpty()) {
                            continue;
                        }
                        System.out.println(color + "Counter = " + counter);
                        counter = 0;
                        if (buffer.get(0).equals(Main.EOF)) {
                            System.out.println(color + "Exiting");
                            break;
                        } else {
                            System.out.println(color + "Removed " + buffer.remove(0));
                        }
                    } finally {
                        bufferLock.unlock();
                    }
                } else {
                    counter++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

