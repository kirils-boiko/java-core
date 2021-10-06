package kiro.javaCore;

public class NumberOfPrimes {

    public static boolean isPrime(int n) {
        // a prime number is a natural number greater than 1 that is not
        //  a product of two smaller natural numbers
        if (n < 2)
            return false;

//        for (int i = 2; i <= n/2; i++) {
//            if (n % i == 0)
//                return false;
//        }

        for (int i = 2; i <= (long)(Math.sqrt(n)); i++) { // optimized
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int getNumberOfPrimesInRange(int start, int end) {

        int count = 0;

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }

        return count;
    }
}
