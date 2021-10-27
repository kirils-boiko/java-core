package com.example.mypackage;

import com.example.series.Series;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 11; i++) {
            System.out.print(Series.nSum(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 11; i++) {
            System.out.print(Series.factorial(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < 11; i++) {
            System.out.print(Series.fibonacci(i) + " ");
        }
        System.out.println();
    }
}

