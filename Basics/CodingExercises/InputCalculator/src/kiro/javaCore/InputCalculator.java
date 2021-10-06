package kiro.javaCore;

import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
        long avg = 0l;

        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                counter++;
                sum += number;
            } else {
                String command = scanner.nextLine();
                avg = Math.round((double)(sum)/counter);
                System.out.println(String.format("SUM = %d AVG = %d",
                        sum, avg));
                sum = counter = 0;
                avg = 0l;
                if (command.equals("exit"))
                    break;
            }
        }

        scanner.close();
    }
}
