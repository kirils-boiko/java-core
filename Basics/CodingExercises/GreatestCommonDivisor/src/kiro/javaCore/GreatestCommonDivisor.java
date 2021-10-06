package kiro.javaCore;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {

        if (first < 10 || second < 10)
            return -1;

        int start = (first > second) ? second : first;

        for (int i = start; i > 1; i--) {
            if ((first % i == 0) && (second % i == 0))
                return i;
        }

        return 1;

    }
}
