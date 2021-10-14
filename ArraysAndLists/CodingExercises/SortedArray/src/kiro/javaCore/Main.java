package kiro.javaCore;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int[] myIntArray = SortedArray.getIntegers(10);
        // QuickSort.quickSort(myIntArray, 0, myIntArray.length - 1);
        // int[] sortedArray = SortedArray.sortArray(myIntArray);
        int[] sortedArray = SortedArray.sortIntegers(myIntArray);
        SortedArray.printArray(myIntArray);
        System.out.println();
        SortedArray.printArray(sortedArray);
    }
}
