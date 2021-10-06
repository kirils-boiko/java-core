package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("10,000 at %d%% interest = %.2f ", i,
                    calculateInterest(10000, i)));
        }

        for (int i = 8; i >= 0; i--) {
            System.out.println(String.format("10,000 at %d%% interest = %.2f ", i,
                    calculateInterest(10000, i)));
        }
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100d);
    }
}
