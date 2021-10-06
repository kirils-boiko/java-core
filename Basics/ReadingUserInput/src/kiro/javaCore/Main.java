package kiro.javaCore;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static final int CURRENT_YEAR = 2021;

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth: ");
        boolean hasNextInt = scanner.hasNextInt();  // peak into the input
        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();         // to read and discard the newline separator

            System.out.println("Enter your full name: ");
            String fullName = scanner.nextLine();

            int age = CURRENT_YEAR - yearOfBirth;
            if (age >= 0 && age <= 120) {    // deal with invalid age
                StringBuilder toPrint = new StringBuilder();
                toPrint.append(String.format("Your name is %s", fullName));
                toPrint.append(String.format(" and you are %d years old.", age));

                System.out.println(toPrint.toString());
            } else {
                System.out.println("error: invalid year of birth");
            }
        } else {
            System.out.println("error: unable to parse year of birth");
        }


        scanner.close();            // free the memory the scanner uses
    }
}
