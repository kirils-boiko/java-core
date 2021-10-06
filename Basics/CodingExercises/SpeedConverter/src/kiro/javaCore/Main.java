package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        System.out.println(SpeedConverter.toMilesPerHour(10));
        System.out.println(SpeedConverter.toMilesPerHour(10.25));
        System.out.println(SpeedConverter.toMilesPerHour(1.5));
        System.out.println(SpeedConverter.toMilesPerHour(1.609));
        System.out.println(SpeedConverter.toMilesPerHour(-100));

        SpeedConverter.printConversion(1.5);
        SpeedConverter.printConversion(10.25);
        SpeedConverter.printConversion(-5.6);
        SpeedConverter.printConversion(25.42);
        SpeedConverter.printConversion(75.114);

    }
}
