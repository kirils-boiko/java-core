package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        int myValue = 1000;

        // Determining the range of primitive data types
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        System.out.println("Integer Minimum Value: " + minIntValue);
        System.out.println("Integer Maximum Value: " + maxIntValue);
        System.out.println("Busted MAX value: " + (maxIntValue + 1));   // overflow

//        int maxIntTest = 2147483648;  // integer number too large
//        System.out.println(maxIntTest);

        int moreReadableInt = 2_147_483_647;
        System.out.println(moreReadableInt);

        byte minByteValue = Byte.MIN_VALUE;
        byte maxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value: " + minByteValue);
        System.out.println("Byte Maximum Value: " + maxByteValue);

        short minShortValue = Short.MIN_VALUE;
        short maxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value: " + minShortValue);
        System.out.println("Short Maximum Value: " + maxShortValue);

        long minLongValue = Long.MIN_VALUE;
        long maxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value: " + minLongValue);
        System.out.println("Long Maximum Value: " + maxLongValue);

        long myLongValue = 100L;
        long largeLongValue = 2_147_483_648L; // without L treats as int
        System.out.println("myLongValue: " + myLongValue);
        System.out.println("largeLongValue: " + largeLongValue);
        // byte occupies 8 bits and thus has a width of 8;
        // short occupies 16 bits and thus has a width of 16;
        // int occupies 32 bits with a width of 32;
        // long occupies 64 bits

        // Casting in Java
        int newIntValue = (maxIntValue / 2);               // int by default - fine
        byte newByteValue = (byte) (minByteValue / 2);     // int by default - requires casting
        short newShortValue = (short) (maxShortValue / 2); // int by default - requires casting
        System.out.println("newIntValue: " + newIntValue);
        System.out.println("newByteValue: " + newByteValue);
        System.out.println("newShortValue: " + newShortValue);

        // Primitive Types Challenge
        byte myByte = 64;
        short myShort = 27000;
        int myInt = 1_000_000_000;
        long myLong = (50000 +  (10 * (myByte + myShort + (long)(myInt))));
        long altSolution = 50000L + 10L * (myByte + myShort + myInt);
        System.out.println("==========================");
        System.out.println("Primitive Types Challenge");
        System.out.println("Result: " + myLong);
        System.out.println("Alt Result: " + altSolution);

    }
}
