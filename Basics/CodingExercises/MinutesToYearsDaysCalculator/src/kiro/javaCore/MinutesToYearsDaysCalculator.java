package kiro.javaCore;

import jdk.swing.interop.SwingInterOpUtils;

public class MinutesToYearsDaysCalculator {

    private static final long MINUTES_IN_DAY = 60l * 24;
    private static final long MINUTES_IN_YEAR = MINUTES_IN_DAY * 365l;

    public static void printYearsAndDays(long minutes) {

        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        long years = minutes / MINUTES_IN_YEAR;
        long days = (minutes % MINUTES_IN_YEAR) / MINUTES_IN_DAY;

        System.out.println(String.format("%d min = %d y and %d d",
                minutes, years, days));

    }
}
