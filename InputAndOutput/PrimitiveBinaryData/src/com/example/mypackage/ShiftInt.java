package com.example.mypackage;

/**
 * Created by timbuchalka on 19/05/2016.
 * Adjusted by kiro-boiko on 03/11/2021.
 */

public class ShiftInt {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        int x = 922342959;

        writeInt(x);
    }


    private static void display(int x) {
        String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
        String colouredBinary = all.substring(0, 24) + ANSI_PURPLE + all.substring(24) + ANSI_RESET;
        int y = x & 0xFF;
        String output = String.format("(hex:%5h / dec:%10d) & 0xFF is %8s \t %10d is ", y, y, Integer.toBinaryString(y), x) + colouredBinary;
        System.out.println(output);
    }

    private static void writeInt(int v) {
        int x;
        String binaryRepresentation = ANSI_GREEN +
                String.format("%32s", Integer.toBinaryString(v)).replace(" ", "0") + ANSI_RESET;
        System.out.println(String.format("dec: %d in bin: %32s", v, binaryRepresentation));
        display(v >>> 24);
        display(v >>> 16);
        display(v >>> 8);
        display(v >>> 0);
    }
}

