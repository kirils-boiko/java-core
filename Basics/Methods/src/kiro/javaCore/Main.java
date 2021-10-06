package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 800;
        int lvlCompleted = 5;
        int bonus = 100;
        printScore(gameOver, score, lvlCompleted, bonus);

        score = 1000;
        lvlCompleted = 10;
        bonus = 200;
        printScore(gameOver, score, lvlCompleted, bonus);

        printScore(true, 7000, 12, 300);

        int finalScore = calculateScore(true, 9000, 20, 250);
        System.out.println("Final score: " + finalScore);

        finalScore = calculateScore(false, 9000, 20, 250);
        if (finalScore < 0)
            System.out.println("Game is not over");
        else
            System.out.println("Final score: " + finalScore);

        // Challenge
        displayPosition("Kiro", calculatePosition(1500));
        displayPosition("John", calculatePosition(900));
        displayPosition("Steven", calculatePositionAlt(500));
        displayPosition("Thor", calculatePositionAlt(50));
        displayPosition("Odin", calculatePosition(-100));
        displayPosition("Loki", calculatePositionAlt(-200));

    }

    public static void printScore(boolean gameOver, int score, int lvlCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (lvlCompleted * bonus);
            System.out.println("Final score: " + finalScore);
        }
    }

    public static int calculateScore(boolean gameOver, int score, int lvlCompleted, int bonus) {
        if (gameOver) {
            int finalScore = score + (lvlCompleted * bonus);
            return finalScore;
        }
        return -1;
    }

    public static void displayPosition (String name, int position) {
        if (position > 0)
            System.out.println(name + " managed to get into position " + position + " on the high score table");
        else
            System.out.println(name + " did not finish the game");
    }

    public static int calculatePosition(int score) {
        if (score > 1000) {
            return 1;
        } else if (score > 500) {
            return 2;
        } else if (score > 100) {
            return 3;
        } else if (score > 0) {
            return 4;
        }

        return -1;
    }

    public static int calculatePositionAlt(int score) {

        int position = -1;

        if (score > 1000) {
            position = 1;
        } else if (score > 500) {
            position = 2;
        } else if (score > 100) {
            position = 3;
        } else if (score > 0) {
            position = 4;
        }
        return position;
    }
}
