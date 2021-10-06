package kiro.javaCore;

public class SecondAndMinutes {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static String getDurationString(int minutes, int seconds) {

        if (minutes < 0 || seconds < 0 || seconds > 59) {
            System.out.println(INVALID_VALUE_MESSAGE);
            return INVALID_VALUE_MESSAGE;
        }

        String toPrint = String.format("%02dh %02dm %02ds", (minutes / 60), (minutes % 60),
                seconds);
        String toPrintTemp = String.format("%02dm %02ds = %s", minutes, seconds, toPrint);
        System.out.println(toPrintTemp);
        return toPrint;
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0)  {
            System.out.println(INVALID_VALUE_MESSAGE);
            return INVALID_VALUE_MESSAGE;
        }

        String toPrint = getDurationString(seconds / 60, seconds % 60);
        String toPrintTemp = String.format("%02ds = %s", seconds, toPrint);
        System.out.println(toPrintTemp);
        return toPrint;

    }
}
