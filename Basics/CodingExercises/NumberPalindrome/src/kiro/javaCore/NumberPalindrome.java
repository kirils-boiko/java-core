package kiro.javaCore;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        if (number < 0)
            number *= -1;

        int reversedNumber = 0;
        int originalNumber = number;

        while (number > 0) {
            reversedNumber *= 10;
            reversedNumber += number % 10;
            number /= 10;
        }

        if (reversedNumber == originalNumber)
            return true;
        else
            return false;
    }
}
