package kiro.javaCore;

import java.util.Scanner;

public class MinimumElement {

    public static int readInteger() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of integers in array:\r");
        int result = scanner.nextInt();

        scanner.close();
        return result;
    }

    public static int[] readElements(int n) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter " + n + " array elements:\r");
        int[] intArray = new int[n];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }

        scanner.close();
        return intArray;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
