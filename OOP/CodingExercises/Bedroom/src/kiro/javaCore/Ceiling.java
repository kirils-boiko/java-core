package kiro.javaCore;

public class Ceiling {
    // internal/component class

    private int height;
    private int paintedColor;

    public Ceiling(int height, int paintedColor) {
        this.height = height > 0 ? height : 0;
        this.paintedColor = paintedColor;
    }

    public int getHeight() {
        return height;
    }

    public int getPaintedColor() {
        return paintedColor;
    }
}
