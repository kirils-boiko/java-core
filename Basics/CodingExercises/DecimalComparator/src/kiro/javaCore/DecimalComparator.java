package kiro.javaCore;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double d1, double d2) {

        int firstDouble = (int) (d1 * 1000d);
        int secondDouble = (int) (d2 * 1000d);

        return (firstDouble == secondDouble) ? true : false;
    }
}
