package com.example.mypackage.blocking_queues;

import com.example.mypackage.ThreadColor;


import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/*
    Simple console application to illustrate the use
    of methods from java.util.concurrent package
 */

public class Main {

    public static void main(String[] args) {

        //============================================================
        // Thread safety using thread-safe blocking queues and synchronized blocks

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producerImproved = new
                MyProducer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumerImproved1 = new
                MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumerImproved2 = new
                MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

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
