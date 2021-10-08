package kiro.javaCore;

public class Dimensions {

    private int width;
    private int length;
    private int height;

    public Dimensions(int width, int length, int height) {
        this.width = (width > 0) ? width : 0;
        this.length = (length > 0) ? length : 0;
        this.height = (height > 0) ? height : 0;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }
}
