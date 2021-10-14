package kiro.javaCore;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	    int[] myIntegers = getIntegers(5);

        printArray(myIntegers);
        System.out.println(String.format("Average of array elements: %.02f",
                getAverage(myIntegers)));
    }

    public static int[] getIntegers(int n) {
        System.out.println("Enter " + n + " integer values:\r");

        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return values;
    }

    public static double getAverage(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("Element #%d: %d", i, array[i]));
        }
    }
}
