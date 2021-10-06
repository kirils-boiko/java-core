package kiro.javaCore;

public class TeenNumberChecker {

    public static boolean isTeen(int age) {
        return (age > 12 && age < 20) ? true : false;
    }

    public static boolean hasTeen(int firstAge, int secondAge, int thirdAge) {
        return (isTeen(firstAge) || isTeen(secondAge) || isTeen(thirdAge)) ?
                true : false;
    }
}
