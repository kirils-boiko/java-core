package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        // char occupies 16bit for storing Unicode characters
        char myChar = 'K';
        char myUnicodeChar = '\u0044';
        char myUnicodeO = '\u004F';
        System.out.print(myChar);
        System.out.print(myUnicodeChar);
        System.out.print(myUnicodeO);

        boolean myTrueBoolean = true;
        boolean myFalseBoolean = false;
        System.out.println();
        System.out.println(myTrueBoolean);
        System.out.println(myFalseBoolean);

    }
}
