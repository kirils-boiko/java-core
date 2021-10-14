package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        // Initialising the array (1st way)
        int[] myIntArray = new int[10];
        double[] myDoubleArray = new double[20];
        myIntArray[5] = 90;     // assigning 90 to 6th element
        myDoubleArray[10] = 777.77;

        // Initialising the array (2nd way) (applicable only at the definition)
        int[] myIntArray1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Initialising the array (3rd way) using for-loop
        int[] myIntArray2 = new int[15];
        for (int i = 0; i < myIntArray2.length; i++) {
            myIntArray2[i] = i * 11;
        }

        // Accessing elements (starting from position zero)
        System.out.println(myIntArray[5]);
        System.out.println(myIntArray1[5]);
        System.out.println(myDoubleArray[10]);

        for (int i = 0; i < myIntArray2.length; i++) {
            System.out.println("Element #" + i + ": " + myIntArray2[i]);
        }

        printArray(myIntArray2);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element #" + i + ": " + array[i]);
        }
    }
}
