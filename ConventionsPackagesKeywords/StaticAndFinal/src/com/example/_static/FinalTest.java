package com.example._static;

public class FinalTest {

    private static int classCounter = 0;
    private final int instanceNumber;
    private final String name;

    public FinalTest(String name) {

        this.name = name;
        classCounter ++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance number: " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
