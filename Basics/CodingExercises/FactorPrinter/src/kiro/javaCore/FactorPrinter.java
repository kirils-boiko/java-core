package kiro.javaCore;

public class FactorPrinter {

    public static void printFactors(int number) {

        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                System.out.print(i + " ");
        }
        System.out.print(number + "\n");

    }
}
