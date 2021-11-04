package com.example.mypackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int x = 9333;
        int y = 0;

        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));
        //system.out.println(divide(x, y));     // throws an error


        x = getIntLBYL();
        System.out.println("x is " + x);

        x = getIntEAFP();
        System.out.println("x is " + x);


    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer:");
        return s.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an integer:");
        String input = s.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer:");
        try {
            return s.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("error: input is not an integer, returning zero");
            return 0;
        }
    }

    private static int divideLBYL(int x, int y) {
        // Look Before You Leap error handling
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        // Easier to Ask for Forgiveness than Permission
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divide(int x, int y) {
        // No error handling
        return x / y;
    }
}
