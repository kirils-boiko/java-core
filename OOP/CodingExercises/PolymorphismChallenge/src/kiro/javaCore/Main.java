package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        Car[] myCars = {new Tesla("Model S", 2, 300),
            new Ferrari("488", 8, 2, 330),
            new Porsche("Carrera GT", false, 10, 2, 330)};

        for (int i = 0; i < myCars.length; i++) {
            Car myCar = myCars[i];
            System.out.println("Car #" + i + ": ");
            System.out.println("Manufacturer = " + myCar.getManufacturer());
            System.out.println("Model: " + myCar.getModel());
            System.out.println("isElectric: " + myCar.isElectric());
            System.out.println("Cylinders: " + myCar.getCylinders());
            System.out.println("Wheels: " + myCar.getWheels());
            System.out.println("Doors: " + myCar.getDoors());
            System.out.println("Max speed: " + myCar.getMaxSpeed());
            myCar.startEngine();
            myCar.accelerate();
            myCar.brake();
            System.out.println();
        }
    }
}
