package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        SecondAndMinutes.getDurationString(400, 34);
        SecondAndMinutes.getDurationString(-400, 34);
        SecondAndMinutes.getDurationString(400, 69);
        SecondAndMinutes.getDurationString(500, 0);
        SecondAndMinutes.getDurationString(525_600, 0);
        SecondAndMinutes.getDurationString(0,0);
        SecondAndMinutes.getDurationString(0);
        SecondAndMinutes.getDurationString(-200);
        SecondAndMinutes.getDurationString(31_536_000);
        SecondAndMinutes.getDurationString(31_536_080);
    }
}
