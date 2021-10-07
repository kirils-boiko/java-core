package kiro.javaCore;

import java.util.Locale;

public class Car {

// Note that Java does add some basic functionality for the class
//  you are creating;

// State components (fields)
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("carrera gt")
            || validModel.equals("cayman") || validModel.equals("cayenne")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel() {
        return this.model;
    }
}
