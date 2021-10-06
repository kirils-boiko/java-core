package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    // parsing values from a string

        String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);  // using Integer wrapper class
        System.out.println("number = " + number);

        double numberDouble = Double.parseDouble(numberAsString);
        System.out.println("numberDouble = " + numberDouble);

        numberAsString += 1;        // concatenating
        number += 1;                // incrementing
        numberDouble += 1;          // incrementing

        System.out.println(numberAsString);
        System.out.println(number);
        System.out.println(numberDouble);
    }
}
