package kiro.javaCore;

public class Resolution {

    private int widthInPixels;
    private int heightInPixels;

    public Resolution(int widthInPixels, int heightInPixels) {
        this.widthInPixels = (widthInPixels > 0) ? widthInPixels : 0;
        this.heightInPixels = (heightInPixels > 0) ? heightInPixels : 0;
    }

    public int getWidthInPixels() {
        return widthInPixels;
    }

    public int getHeightInPixels() {
        return heightInPixels;
    }
}
