package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    Car porsche = new Car();        // create Car object and initialize it
        System.out.println(porsche.getModel());
        porsche.setModel("Carrera GT");
        System.out.println(porsche.getModel());

        Car mitsubishi = new Car();
        mitsubishi.setModel("Space Star");
        System.out.println(mitsubishi.getModel());
    }
}
