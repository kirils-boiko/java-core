package kiro.javaCore;

public class Rectangle extends Shape {
    private int width;
    private int height;

    // Using the constructor chaining;
    // Using this keyword for accessing current class members
    // Using this() and super() calls for calls to overloaded constructors
    //  of the current class and constructors of the parent class

    public Rectangle(int x, int y) {
        this(x,y,0,0);
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
}
