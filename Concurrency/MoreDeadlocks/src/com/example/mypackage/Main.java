package com.example.mypackage;


/*
    Why does the deadlock occurs?
    Thread 1 acquires the lock for jane object, calls sayHello(john), prints
        out to the console, and suspends while still holding the jane lock;
    Thread 2 acquires the lock for john object, calls sayHello(jane), prints
        out to the console, and suspends while still holding the john lock;
    Thread 1 wakes up, tries to run the synchronized method of john's object -
        sayHelloBack(jane), but blocks since john's lock is blocked by Thread 2;
    Thread 2 wakes up, tries to run the synchronized method of jane's object -
        sayHelloBack(john), but blocks since jane's lock is blocked by Thread 2;
 */

public class Main {

    public static void main(String[] args) {

        final PolitePerson jane = new PolitePerson("Jane");
        final PolitePerson john = new PolitePerson("John");

//        jane.sayHello(john);
//        john.sayHello(jane);

        new Thread(new Runnable() {
            @Override
            public void run() {
               jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();

    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!%n",
                    this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!%n",
                    this.name, person.getName());
        }
    }
}
