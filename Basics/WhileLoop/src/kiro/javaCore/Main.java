package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("Another count value is " + count);
            count++;
        }

        count = 6;
        do {
            System.out.println("Do-while count value was " + count);
            count++;
        } while (count < 6);

        // Challenge
        int number = 4;
        int finishNumber = 10;
        int countEvenNumbers = 0;

        while (number <= finishNumber) {
            if (isEvenNumber(number)) {
                System.out.println("Even number " + number);
                countEvenNumbers++;
            }
            if (countEvenNumbers > 4)
                break;
            number++;
        }

        System.out.println("Even numbers found: " + countEvenNumbers);

    }

    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0)
            return true;
        return false;
    }
}
