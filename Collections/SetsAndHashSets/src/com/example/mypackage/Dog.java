package com.example.mypackage;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj)    // referential comparison (by memory address)
            return true;

        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }
}
