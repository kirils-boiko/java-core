package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        
        float minFloatValue = Float.MIN_VALUE;
        float maxFloatValue = Float.MAX_VALUE;
        System.out.println("Float Minimum Value: " + minFloatValue);
        System.out.println("Float Maximum Value: " + maxFloatValue);

        double minDoubleValue = Double.MIN_VALUE;
        double maxDoubleValue = Double.MAX_VALUE;
        System.out.println("Double Minimum Value: " + minDoubleValue);
        System.out.println("Double Maximum Value: " + maxDoubleValue);

        int myInt = 5;
        float myFloat = 5.25f;
        float myFloat2 = (float)(5.25);
        double myDouble = 5d;
        System.out.println("myInt: " + myInt);
        System.out.println("myFloat: " + myFloat);
        System.out.println("myFloat2: " + myFloat2);
        System.out.println("myDouble: " + myDouble);

        int myIntDivision = 5 / 2;
        float myFloatDivision = 5f / 2f;
        double myDoubleDivision = 5d / 2d;
        double myDoubleIntDivision = 5d / 2;
        System.out.println("myIntDivision: " + myIntDivision);
        System.out.println("myFloatDivision: " + myFloatDivision);
        System.out.println("myDoubleDivision: " + myDoubleDivision);
        System.out.println("myDoubleIntDivision: " + myDoubleIntDivision);

        // Challenge
        System.out.println("=========================");
        System.out.println("Floating Point Precision Challenge");
        double pounds = 100d;
        double kilograms = pounds * 0.45359237d;
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");

        // Note:
        double anotherNumber = 7_777_777.6_666_666d;
        System.out.println(anotherNumber);
    }
}
