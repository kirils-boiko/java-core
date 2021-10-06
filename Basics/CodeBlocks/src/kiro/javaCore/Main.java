package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 5000;
        int lvlCompleted = 5;
        int bonus = 100;

        if (gameOver) {
            System.out.println("Your score: " + score);
            System.out.println("Levels completed: " + lvlCompleted);
            System.out.println("Bonus earned: " + bonus);
            int finalScore = score + (lvlCompleted * bonus);
            System.out.println("Final score: " + finalScore);
        } else {
            System.out.println("Game is not over");
        }
    }
}
