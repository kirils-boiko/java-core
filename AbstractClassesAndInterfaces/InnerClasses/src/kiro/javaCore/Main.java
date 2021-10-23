package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    Gearbox mcLaren = new Gearbox(6);
//        if Gear is a public inner class
//        Gearbox.Gear first = mcLaren.new Gear(1, 0.02);
//        Gearbox.Gear second = new Gearbox.Gear(2, 0.05);  // not correct
//        Gearbox.Gear third = new mcLaren.Gear(3, 0.06);   // not correct
//        System.out.println(first.driveSpeed(2000));

//        if Gear is a private inner class (correct way)
        mcLaren.addGear(1, 0.005);
        mcLaren.addGear(2, 0.010);
        mcLaren.addGear(3, 0.020);

        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        for (int i = 1000; i < 5000; i += 1000)
            System.out.println("Current wheel speed: " +
                    mcLaren.wheelSpeed(i) + "km/h");

        mcLaren.operateClutch(true);
        mcLaren.changeGear(2);
        mcLaren.operateClutch(false);
        for (int i = 2000; i < 6000; i += 1000)
            System.out.println("Current wheel speed: " +
                    mcLaren.wheelSpeed(i) + "km/h");

        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        for (int i = 2000; i < 6000; i += 1000)
            System.out.println("Current wheel speed: " +
                    mcLaren.wheelSpeed(i) + "km/h");

        mcLaren.changeGear(2);
        mcLaren.operateClutch(true);
        mcLaren.wheelSpeed(2000);
    }
}
