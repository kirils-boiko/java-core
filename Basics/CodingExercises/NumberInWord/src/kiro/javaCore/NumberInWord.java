package kiro.javaCore;

public class NumberInWord {

    public static void printNumberInWord(int number) {

        if (number > 9 || number < 0) {
            System.out.println("OTHER");
            return;
        }

        String[] numbersInWords = { "ZERO", "ONE", "TWO", "THREE",
                    "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE" };
        System.out.println(numbersInWords[number]);
    }
}
