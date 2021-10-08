package kiro.javaCore;

// Composition is the way to model a has-a relationship (composition)
//  without having an is-a relationship (inheritance);
// Check the Computer class for a good illustration of has-a relationships;

import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {

        // Components for computer components
        Resolution fullHD = new Resolution(1920, 1280);
        // dimensions for the aCase is created on the spot;

        // Computer components
        Case aCase = new Case("220B", "Dell",
                "240V",
                new Dimensions(20, 20, 10));
        Monitor monitor = new Monitor("LS24R350", "Samsung",
                24, fullHD);
        Motherboard motherboard = new Motherboard("BJ-200", "Asus",
                4, 6, "v2.44");

        // Computer with directly accessible composition
//        Computer computer = new Computer(motherboard, aCase, monitor);
//        computer.getCase().pressPowerButton();
//        computer.getMotherboard().loadProgram("IntelliJ IDEA");
//        computer.getMonitor().drawPixelAt(1500,1200, "red");


        // Computer with hidden composition
        Computer computer = new Computer(motherboard, aCase, monitor);
        computer.powerUp();
        computer.loadProgram("IntelliJ IDEA");

    }
}
