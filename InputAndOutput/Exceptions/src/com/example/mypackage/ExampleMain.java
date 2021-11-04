package com.example.mypackage;

import javax.lang.model.type.ArrayType;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExampleMain {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println("Result of division : " + result);
        } catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, shutting down...");
        }

    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("attempt to divide by zero");
        }

    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an integer:");
        while (true) {
            try {
                return s.nextInt();
            } catch(InputMismatchException e) {
                // go round again. read past the end of line in the input
                s.nextLine();
                System.out.println("Please enter a number using digits 0 to 9");
            }
        }
    }
}
