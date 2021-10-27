package com.example.mypackage;

public class X {

    private int x;

    public X(int x) {
        this.x = x;
    }

    public void x() {
        System.out.println("Times table:");
        for (int x = 0; x < 13; x++) {
            System.out.println(this.x + " x " + x + " = " + this.x * x);
        }
    }
}
