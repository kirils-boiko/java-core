package kiro.javaCore;

public class Lighting {

    private String type;
    private String color;
    private boolean isOn;

    public Lighting(String type, String color) {
        this.type = type;
        this.color = color;
        this.isOn = false;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public boolean isOn() {
        return isOn;
    }

    public void hitSwitch() {
        if (!isOn) {
            isOn = true;
            System.out.println(type + " lights are now turned on; Room is lit in " +
                    color + " colors;");
        } else {
            isOn = false;
            System.out.println("Lights are now turned off;");
        }
    }

    public void changeType(String type) {
        this.type = type;
        System.out.println("Lights type is changed to " + this.type);
    }

    public void changeColor(String color) {
        this.color = color;
        System.out.println("Lights color is changed to " + this.color);
    }
}
