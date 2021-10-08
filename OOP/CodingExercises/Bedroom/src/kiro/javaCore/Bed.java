package kiro.javaCore;

public class Bed {
    //internal/component class

    private String style;
    private int height;
    private int pillows;
    private int sheets;
    private int quilt;

    public Bed(String style, int height, int pillows, int sheets, int quilt) {
        this.style = style;
        this.height = height > 0 ? height : 0;
        this.pillows = pillows > 0 ? pillows : 0;
        this.sheets = sheets > 0 ? sheets : 0;
        this.quilt = quilt > 0 ? quilt : 0;
    }

    public String getStyle() {
        return style;
    }

    public int getHeight() {
        return height;
    }

    public int getPillows() {
        return pillows;
    }

    public int getSheets() {
        return sheets;
    }

    public int getQuilt() {
        return quilt;
    }

    public void make() {
        System.out.println("Bed is being made");
    }
}
