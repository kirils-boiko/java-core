package kiro.javaCore;

import com.sun.security.jgss.GSSUtil;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);

        newScore = calculateScore(1000);
        System.out.println("New score is " + newScore);

        int lastScore = calculateScore();
        System.out.println("Last score is " + lastScore);

        // challenge
         feetAndInchesToCentimeters(23.4, 0);
         feetAndInchesToCentimeters(10, 7);
         feetAndInchesToCentimeters(17.4);
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " has scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score) {
        // overloaded method with 1 parameter
        System.out.println("Unnamed player has scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return -1;
    }

    public static double feetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || inches < 0 || inches > 12)
            return -1;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        double centimeters = (feet * 12d * 2.54d) + (inches * 2.54d);
        System.out.println(df.format(feet) + "ft and " + df.format(inches) + "in = " + df.format(centimeters) + "cm");
        return centimeters;
    }

    public static double feetAndInchesToCentimeters(double inches) {
        if (inches < 0)
            return -1;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        double centimeters = feetAndInchesToCentimeters((int)(inches) / 12, inches % 12);
        System.out.println(df.format(inches) + "in = " + df.format(centimeters) + "cm");
        return centimeters;
    }
}
