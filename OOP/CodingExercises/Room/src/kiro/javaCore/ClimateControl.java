package kiro.javaCore;

public class ClimateControl {

    private boolean isOn;
    private int temperature;

    public ClimateControl() {
        this(0);
    }

    public ClimateControl(int temperature) {
        this.temperature = temperature;
        this.isOn  = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public int getTemperature() {
        return temperature;
    }

    public void pressPowerButton() {
        if (isOn) {
            System.out.println("Climate control is now turned off;");
            isOn = false;
        } else {
            System.out.println("Climate control is now working; Temperature set to " +
                    temperature + " Celsius");
            isOn = true;
        }
    }

    public void setTemperature(int temperature) {
        if (temperature < 10)
            temperature = 10;
        if (temperature > 35)
            temperature = 35;

        this.temperature = temperature;
        System.out.println("Climate control temperature set to " + temperature +
                " Celsius");
    }
}
