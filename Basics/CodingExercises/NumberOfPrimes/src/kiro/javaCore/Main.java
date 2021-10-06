package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        System.out.println("Number of primes: " + NumberOfPrimes.getNumberOfPrimesInRange(0, 11));
        System.out.println("Number of primes: " + NumberOfPrimes.getNumberOfPrimesInRange(-1, 0));
        System.out.println("Number of primes: " + NumberOfPrimes.getNumberOfPrimesInRange(-20, -39));
        System.out.println("Number of primes: " + NumberOfPrimes.getNumberOfPrimesInRange(-20, 11));
        System.out.println("Number of primes: " + NumberOfPrimes.getNumberOfPrimesInRange(0, 30));
    }
}
