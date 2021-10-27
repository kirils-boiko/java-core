package kiro.javaCore;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    // Naive implementation of the sorting the array of integers in desc order

    public static int[] getIntegers(int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + n + " integers:\r");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(String.format("Element %d contents %d",
                    i, array[i]));
        }

    }

    public static int[] sortIntegers(int[] array) {
        // sort in descending order

        // easy naive solution using one array
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array.length; j++) {
//                if (array[j] > array[i]) {
//                    // swap the elements
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
//            }
//        }


        // required naive solution using two arrays
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i; j < sortedArray.length; j++) {
                if (sortedArray[j] > sortedArray[i]) {
                    // swap the elements
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }

        return sortedArray;
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            sortedArray[i] = array[i];
        }

        boolean flag = true;
        while (flag) {
            flag = false;

            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }

}


