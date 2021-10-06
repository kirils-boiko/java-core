import java.util.Scanner;

public class ReadingInput {

    public static void readNumbers(int counter) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int reverseCounter = 1;

        while (counter > 0) {
            System.out.print(String.format("Enter number #%d: ", reverseCounter));
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
                scanner.nextLine();
                counter--;
                reverseCounter++;
            } else {
                scanner.nextLine();
                System.out.println("Invalid Value");
            }
        }

        System.out.println(String.format("Sum of the entered numbers: %d", sum));

        scanner.close();
    }
}
