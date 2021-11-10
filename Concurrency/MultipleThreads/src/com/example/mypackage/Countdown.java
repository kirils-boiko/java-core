package com.example.mypackage;

public class Countdown {

    private int i;

    // you can make the entire method synchronized by adding the synchronized keyword
    public void doCountdown() {
       String color;

       switch(Thread.currentThread().getName()) {
           case "Thread 1":
               color = ThreadColor.ANSI_PURPLE;
               break;
           case "Thread 2":
               color = ThreadColor.ANSI_GREEN;
               break;
           default:
               color = ThreadColor.ANSI_BLUE;
               break;
       }

       synchronized (this) {
           for (i = 10; i > 0; i--) {
               System.out.println(color + Thread.currentThread().getName() + ": " + i);
           }
       }
   }
}
