package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        // blueHouse is a reference to the object in memory:
        //  new House(...) creates an object in memory;
        //  blueHouse points to that object in memory;
        //  anotherHouse also points to that object in memory;
        House blueHouse = new House("blue");
        House anotherHouse = blueHouse;

        System.out.println(blueHouse.getColor());   // blue
        System.out.println(anotherHouse.getColor());    // blue

        anotherHouse.setColor("yellow");
        System.out.println(blueHouse.getColor());   // yellow
        System.out.println(anotherHouse.getColor());    // yellow

        House greenHouse = new House("green");
        anotherHouse = greenHouse;

        System.out.println(blueHouse.getColor()); // yellow
        System.out.println(greenHouse.getColor());  // green
        System.out.println(anotherHouse.getColor());    // green

    }
}
