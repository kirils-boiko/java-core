package kiro.javaCore;

import java.util.Scanner;

public class ReadingInput {

    public static void minAndMaxInput() {
        Scanner scanner = new Scanner(System.in);

//        int min = 0, max = 0;
//        boolean firstInput = true;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        while (true) {
            System.out.print("Enter number: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
//                if (firstInput) {
//                    max = min = number;
//                    firstInput = false;
//                    continue;
//                }
                if (number < min)
                    min = number;
                if (number > max)
                    max = number;
            } else {
                break;
            }
        }

//        if (firstInput) {
//            System.out.println("error: no numbers provided");
//        } else {
//            System.out.println(String.format("Min = %d; Max = %d;", min, max));
//        }

        System.out.println(String.format("Min = %d; Max = %d;", min, max));

        scanner.close();
    }
}
