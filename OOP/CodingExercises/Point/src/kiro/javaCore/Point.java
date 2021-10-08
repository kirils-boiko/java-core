package kiro.javaCore;

public class Point {

    private int x;
    private int y;

    public Point() {
        this (0, 0);
        System.out.println("Empty constructor called");
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Constructor with 2 parameters called");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        // distance between this point and (0,0)
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public double distance(int x, int y) {
        // distance between this point and (x,y)\
        return Math.sqrt(Math.pow((x - this.x),2) + Math.pow((y - this.y),2));
    }

    public double distance(Point p) {
        // distance between this point and p
        return Math.sqrt(Math.pow((p.x - this.x),2) + Math.pow((p.y - this.y),2));
    }

}
