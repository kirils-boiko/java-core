package kiro.javaCore;

public class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolution;        // example of composition

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = (size > 0) ? size : 0;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println(String.format("Drawing pixel at (%d,%d) in color %s",
                x, y, color));
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
