package kiro.javaCore;

import java.util.Arrays;

public class ReverseArray {

    public static void reverse(int[] array) {
        System.out.println("Array = " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1 - i; i++) { // can use i < array.length/2 instead
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
    }
}
