package kiro.javaCore;

public class Lamp {
    // internal/component class

    private String style;
    private boolean battery;
    private int globRating;

    public Lamp(String style, boolean battery, int globRating) {
        this.style = style;
        this.battery = battery;
        this.globRating = globRating > 0 ? globRating : 0;
    }

    public String getStyle() {
        return style;
    }

    public boolean isBattery() {
        return battery;
    }

    public int getGlobRating() {
        return globRating;
    }

    public void turnOn() {
        System.out.println("The lamp is being turned on");
    }
}
