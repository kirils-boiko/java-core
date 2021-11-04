package com.example.mypackage;

public class DogMain {

    // Illustrating the use of a faulty equals() method that does not
    //  check whether the compared object is a subclass of this object;

    public static void main(String[] args) {
        Labrador rover = new Labrador("rover");
        Dog rover2 = new Dog("rover");


        // rule of symmetry is violated if equals() method is overridden in Labrador class
        // but if you make the equals() method final in parent class Dog, everything's fine;
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }

}
