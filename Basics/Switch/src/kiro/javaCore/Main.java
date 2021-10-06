package kiro.javaCore;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int switchValue = 6;
        switch (switchValue) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3:
                System.out.println("Value is 3");
                break;
            case 4: case 5: case 6:
                System.out.println("Value is 4, 5, or 6");
                System.out.println("Actually, it's " + switchValue);
                break;
            default:
                System.out.println("Default value");
                break;
        }

        String month = "January";
        switch(month.toLowerCase()) {
            case "january":
                System.out.println("Coldest Month");
                break;
            case "july":
                System.out.println("Hottest Month");
                break;
            default:
                System.out.println("Other Month");
                break;
        }

    }
}
