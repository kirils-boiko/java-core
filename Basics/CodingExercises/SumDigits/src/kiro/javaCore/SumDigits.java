package kiro.javaCore;

public class SumDigits {

    public static int getSumOfDigits(int number) {

        if (number < 10)
            return -1;

        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
