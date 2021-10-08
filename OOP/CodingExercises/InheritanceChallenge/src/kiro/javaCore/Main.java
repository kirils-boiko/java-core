package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        Tesla myTesla = new Tesla("Model S", 2, 322,
                100, true, true, true);
        myTesla.accelerate(50);
        myTesla.steer(60);
        myTesla.stop();
        myTesla.accelerate(100);
        myTesla.brake(50);
        myTesla.changeVelocity(100, 90);
    }
}
