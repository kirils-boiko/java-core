package kiro.javaCore;

public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (hourOfDay < 0 || hourOfDay > 23)
            return false;

        if ((hourOfDay > 22 || hourOfDay < 8) && barking)
            return true;

        return false;
    }
}
