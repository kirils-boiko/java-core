package kiro.javaCore;

public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }
        int numberOfMB = kiloBytes / 1024;
        int numberOfKB = kiloBytes % 1024;

        System.out.println(kiloBytes +  " KB = " + numberOfMB + " MB and " +
                numberOfKB + " KB");

    }
}
