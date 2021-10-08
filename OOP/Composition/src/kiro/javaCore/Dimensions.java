package kiro.javaCore;

public class Dimensions {

    private int widthInCm;
    private int lengthInCm;
    private int heightInCm;

    public Dimensions(int widthInCm, int lengthInCm, int heightInCm) {
        this.widthInCm = widthInCm > 0 ? widthInCm : 0;
        this.lengthInCm = lengthInCm > 0 ? lengthInCm : 0;
        this.heightInCm = heightInCm > 0 ? heightInCm : 0;
    }

    public int getWidthInCm() {
        return widthInCm;
    }

    public int getLengthInCm() {
        return lengthInCm;
    }

    public int getHeightInCm() {
        return heightInCm;
    }
}
