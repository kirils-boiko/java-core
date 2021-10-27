package com.example._static;

public class SIBTest {
    // Static Initialization Block Test Class

    public static final String owner;

    static {
        owner = "Kiro";
        System.out.println("1st SIBTest static init block called");
    }

    public SIBTest() {
        System.out.println("SIBTest constructor called");
    }

    static {
        System.out.println("2nd SIBTest static init block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
