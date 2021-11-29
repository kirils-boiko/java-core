package com.example.mypackage.reentrant_locks;

import com.example.mypackage.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/*
    Simple console application to illustrate the use
    of methods from java.util.concurrent package
 */

public class Main {

    public static void main(String[] args) {

        //============================================================
        // Thread safety using ReentrantLock and java.util.concurrent

        List<String> bufferImproved = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock(); // for java.util.Concurrent

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producerImproved = new
                MyProducer(bufferImproved, ThreadColor.ANSI_RED, bufferLock);
        MyConsumer consumerImproved1 = new
                MyConsumer(bufferImproved, ThreadColor.ANSI_BLUE, bufferLock);
        MyConsumer consumerImproved2 = new
                MyConsumer(bufferImproved, ThreadColor.ANSI_PURPLE, bufferLock);

        // Starting the threads my passing in the objects which implement Runnable interface

        executorService.execute(producerImproved);
        executorService.execute(consumerImproved1);
        executorService.execute(consumerImproved2);

        // returning a Future value from the thread
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_GREEN + "Printed from Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("ExecutionException");
        } catch (InterruptedException e) {
            System.out.println("Thread running a task was interrupted");
        }

        executorService.shutdown();
    }
}
