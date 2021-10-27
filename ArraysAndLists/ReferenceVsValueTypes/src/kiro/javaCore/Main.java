package kiro.javaCore;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int myIntValue = 10;                    // value types
        int anotherIntValue = myIntValue;       // separate variable

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        anotherIntValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        int[] myIntArray = new int[5];          // reference type
        int[] anotherIntArray = myIntArray;     // no new operator: same address as myIntArray

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        anotherIntArray[2] = 100;
        myIntArray[3] = 999;
        myIntArray[0] = myIntValue;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        modifyArray(myIntArray);

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        anotherIntArray = new int[]{4,5,6,7,8};
        modifyArray(myIntArray);

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));


    }

    public static void modifyArray(int[] array) {   // parameter is a reference to array

        array[0] = 2;
        array = new int[] {1,2,3,4,5};      // de-referencing the parameter
    }
}
