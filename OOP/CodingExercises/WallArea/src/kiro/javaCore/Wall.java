package kiro.javaCore;

public class Wall {

    private double width;
    private double height;

    public Wall() {
        //  no-arg constructor
        this(0.0, 0.0);
        System.out.println("Empty constructor called");
    }

    public Wall(double width, double height) {
        // two-arg constructor
        if (width < 0) {
            System.out.println("error: negative width parameter; set to default value");
            width = 0.0;
        }

        if (height < 0) {
            System.out.println("error: negative height parameter; set to default value");
            height = 0.0;
        }

        this.width = width;
        this.height = height;
        System.out.println("Constructor with 2 parameters called");
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            System.out.println("error: negative width parameter; set to default value");
            width = 0;
        }
        this.width = width;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            System.out.println("error: negative height parameter; set to default value");
            height = 0;
        }
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}
