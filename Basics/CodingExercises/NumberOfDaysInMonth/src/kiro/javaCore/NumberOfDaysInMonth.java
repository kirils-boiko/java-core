package kiro.javaCore;

public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {

        if (year < 1 || year > 9999)
            return false;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            } else
                return true;
        } else
            return false;
    }

    public static int getDaysInMonth(int month, int year) {

        if (month < 1 || month > 12 || year < 1 || year > 9999)
            return -1;

        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year))
            return 29;
        else
            return daysInMonths[month-1];
    }
}
