package kiro.javaCore;

public class PerfectNumber {

    public static boolean isPerfectNumber(int number) {
        // A perfect number is a positive integer which is equal to the sum
        //  of its proper positive divisors; proper positive divisors are
        //  positive integers that fully divide the perfect number (without
        //  a remainder) and exclude the perfect number itself;

        if (number < 1)
            return false;

        int sumOfProperDivisors = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                sumOfProperDivisors +=i;
        }

        return sumOfProperDivisors == number;
    }
}
