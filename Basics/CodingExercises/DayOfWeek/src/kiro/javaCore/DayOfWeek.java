package kiro.javaCore;

public class DayOfWeek {

    public static void printDayOfTheWeek(int day) {

        if (day < 1 || day > 7) {
            System.out.println("Invalid day");
            return;
        }

        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday",
                    "Thursday", "Friday", "Saturday"};
        System.out.println(days[day-1]);
    }
}
