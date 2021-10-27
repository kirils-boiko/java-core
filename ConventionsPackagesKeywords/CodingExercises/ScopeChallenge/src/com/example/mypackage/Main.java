package com.example.mypackage;

// Naming variables like that is an awful programming practice: don't do that

import java.util.Scanner;

public class Main {

    private static final Scanner x = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter an integer:");

        if (Main.x.hasNextInt()) {
            X x = new X(Main.x.nextInt());
            x.x();
        } else {
            System.out.println("error: integer required");
            return;
        }

    }
}
