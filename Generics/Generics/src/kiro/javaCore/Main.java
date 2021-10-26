package kiro.javaCore;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        // items.add("valid");      // valid but breaks the code when casting
        items.add(4);
        items.add(5);

        printDoubled(items);

        ArrayList<Integer> intItems = new ArrayList<>();
        intItems.add(10);
        intItems.add(20);
        intItems.add(30);
        intItems.add(40);
        intItems.add(50);
        printDoubledInts(intItems);
    }

    private static void printDoubled(ArrayList n) {
        // casting is required as ArrayList stores Objects not Integers;
        for (Object i : n) {
            System.out.println((Integer) i * 2);
        }
    }

    private static void printDoubledInts(ArrayList<Integer> list) {
        for (Integer i : list) {
            System.out.println(i * 2);
        }
    }
}
