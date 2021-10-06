package kiro.javaCore;

public class NumberToWords {

    private static final String[] DIGITS_IN_WORDS = 
            {"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"}; 
    
    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int reversedNumber = reverse(number);
        String numberInWords = new String("");
        int differenceInDigits = getDigitCount(number) - getDigitCount(reversedNumber);

        do {
            int digit = reversedNumber % 10;
            String delimiter = (numberInWords.isEmpty()) ? "" : " ";
            numberInWords = String.join(delimiter, numberInWords,
                    DIGITS_IN_WORDS[digit]);
            reversedNumber /= 10;
        } while (reversedNumber != 0);

        while (differenceInDigits > 0) {
            numberInWords = String.join(" ", numberInWords,
                    DIGITS_IN_WORDS[0]);
            differenceInDigits--;
        }

        System.out.println(numberInWords);
        return;
    }

    public static int reverse(int number) {

        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber *= 10;
            reversedNumber += number % 10;
            number /= 10;
        }

        return reversedNumber;
    }

    public static int getDigitCount(int number) {

        if (number < 0)
            return -1;

        if (number == 0)
            return 1;

        int numberOfDigits = 0;
        while (number > 0) {
            number /= 10;
            numberOfDigits++;
        }

        return numberOfDigits;

    }
}
