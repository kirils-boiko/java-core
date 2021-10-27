package kiro.javaCore;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {
        System.out.println("Enter 10 integers:");
        getInput();
        printArray(baseData);
        resizeArray(12);
        System.out.println("Enter 12 integers:");
        getInput();
        printArray(baseData);
    }

    private static void getInput() {
        for (int i = 0; i < baseData.length; i++) {
            baseData[i] = s.nextInt();
        }
    }

    private static void printArray(int[] arr) {
        System.out.println("baseData: " + Arrays.toString(arr));
    }

    private static void resizeArray(int newSize) {
        if (newSize < baseData.length) {
            System.out.println("error: newSize is smaller than the current size of array");
            return;
        }
        int[] original = baseData;

        baseData = new int[newSize];
        for (int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }
    }
}
