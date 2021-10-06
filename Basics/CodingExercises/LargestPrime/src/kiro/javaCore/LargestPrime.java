package kiro.javaCore;

public class LargestPrime {

    public static int getLargestPrime(int number) {

        int largestPrimeFactor = -1;

        if (number < 2)
            return largestPrimeFactor;

        while (number % 2 == 0) {
            // while number is divisible by 2, 2 is the largest prime factor
            largestPrimeFactor = 2;
            number /= 2;
        }

        for (int i = 3; i <= (long)(Math.sqrt(number)); i +=2) {
            // i increases by 2 to get only odd numbers;
            while (number % i == 0) {
                largestPrimeFactor = i;
                number /= i;
            }
        }

        if (number > 2) {
            largestPrimeFactor = number;
        }

        return largestPrimeFactor;
    }
}
