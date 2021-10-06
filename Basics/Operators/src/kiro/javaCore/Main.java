package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        int result = 1 + 2;
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        System.out.println("previousResult = " + previousResult);
        result -= 1;
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult (unchanged) = " + previousResult);

        result = result * 10;
        System.out.println("2 * 10 = " + result);

        result = result / 5;
        System.out.println("20 / 5 = " + result);

        result = result % 3;
        System.out.println("4 % 3 = " + result);

        // abbreviating operators
        result++;
        result--;
        result += 30;
        result *= 2;
        result /= 3;
        System.out.println("Final result: " + result);  // (1 + 1 - 1 + 30) * 2 / 3 = 20


        // if-then statement
        boolean isHuman = true;
        boolean isAlien = false;
        if (isHuman == true)
            System.out.println("It is a human");
        if (isHuman)
            System.out.println("It is also a human");
        if (isAlien == false)
            System.out.println("It is not an alien");
        if (!isAlien)
            System.out.println("It is not an alien, too");

        if (isHuman && !isAlien) {
            System.out.println();
            System.out.println("It is a human and not an alien");
            System.out.println("How bout that?");
        }

        int topScore = 100;
        int averageScore = 50;
        int yourScore = 30;
        if (yourScore > 100 || yourScore < 0) {
            System.out.println("Your score is invalid");
        } else if (yourScore == topScore) {
            System.out.println("Your score is a top score!");
        } else if (yourScore < topScore && yourScore > averageScore) {
            System.out.println("Your score is a high score!");
        } else if (yourScore == averageScore) {
            System.out.println("Your score is average!");
        } else if (yourScore < averageScore) {
            System.out.println("Your score is below average");
        }

        // ternary operator ? :
        boolean isHigh = (yourScore > averageScore) ? true : false;
        if (isHigh) {
            System.out.println("Your score is high");
        } else {
            System.out.println("Losah");
        }

        // Challenge
        System.out.println("==================================");
        System.out.println("Operators Challenge");
        System.out.println();
        double myFirst = 20.00d;
        double mySecond = 80.00d;
        double intermediateResult = ((myFirst + mySecond) * 100.00d) % 40.00;
        boolean isZero = (intermediateResult == 0) ? true : false;
        System.out.println(isZero);
        if (!isZero) {
            System.out.printf("Remainder is not zero");
        } else {
            System.out.println("Remainder is zero");
        }
    }
}
