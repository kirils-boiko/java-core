package kiro.javaCore;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // cannot create an ArrayList of primitive types
        // ArrayList<int> intArrayList = new ArrayList<int>();

        // use the wrapper class instead
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            intArrayList.add(Integer.valueOf(i));   // autoboxing: converting from primitive to wrapper
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
            // unboxing: converting from wrapper to primitive
        }

        //--------------------------------------------------
        // short version (using the automatic autoboxing and unboxing)
        Integer myIntValue = 56;    // autoboxing: converted to Integer.valueOf(56) at compile time
        int anotherIntValue = myIntValue;   // unboxing: converted to myIntValue.intValue() at compile time

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            System.out.println(i + " --> " + myDoubleValues.get(i));
        }
    }
}
