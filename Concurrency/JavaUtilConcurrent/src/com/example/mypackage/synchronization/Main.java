package com.example.mypackage.synchronization;

import com.example.mypackage.ThreadColor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {

        //============================================================
        // Thread safety using synchronization

        // Shared heap resources
        List<String> buffer = new ArrayList<>();

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

        // Starting the threads my passing in the objects which implement Runnable interface
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }

}
