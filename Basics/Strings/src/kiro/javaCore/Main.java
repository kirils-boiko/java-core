package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        // this way of appending strings is inefficient, use StringBuffer instead
        String myString = "Kiro Boiko";
        System.out.println("myString: " + myString);
        myString = myString + ", software developer";
        System.out.println("myString: " + myString);
        myString = myString + " \u0801";
        System.out.println("myString: " + myString);

        String numberString = "777.333";
        int myInt = 10;
        numberString = numberString + " " + myInt;          // converts numerical into string
        System.out.println(numberString);
        double myDouble = 20.33d;
        numberString = numberString + " " + myDouble;
        System.out.println(numberString);
    }
}
