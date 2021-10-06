package kiro.javaCore;

public class SharedDigit {

    public static boolean hasSharedDigit(int firstNumber, int secondNumber) {

        if (firstNumber < 10 || firstNumber > 99 ||
                secondNumber < 10 || secondNumber > 99)
            return false;

        int firstNumberLastDigit  = firstNumber % 10;
        int firstNumberFirstDigit = firstNumber / 10;
        int secondNumberLastDigit = secondNumber % 10;
        int secondNumberFirstDigit = secondNumber / 10;

         return (firstNumberFirstDigit == secondNumberFirstDigit) ||
                (firstNumberFirstDigit == secondNumberLastDigit) ||
                (firstNumberLastDigit == secondNumberFirstDigit) ||
                (firstNumberLastDigit == secondNumberLastDigit);
    }
}
