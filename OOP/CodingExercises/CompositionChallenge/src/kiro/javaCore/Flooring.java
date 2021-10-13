package kiro.javaCore;

public class Flooring {

    private int width;
    private int length;
    private String material;
    private boolean isSoundproof;

    public Flooring(int width, int length, String material, boolean isSoundproof) {
        this.width = width;
        this.length = length;
        this.material = material;
        this.isSoundproof = isSoundproof;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isSoundproof() {
        return isSoundproof;
    }
}
