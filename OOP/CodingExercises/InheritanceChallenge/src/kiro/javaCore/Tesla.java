package kiro.javaCore;

public class Tesla extends Car {

    private String model;
    private int batteryCapacity;
    private boolean hasPlaidMode;
    private boolean hasDogMode;
    private boolean hasFartMode;


    public Tesla(String model, int doors, int maxSpeed,
                 int batteryCapacity, boolean hasPlaidMode,
                 boolean hasDogMode, boolean hasFartMode) {
        super("Tesla", "AWD", 4, doors, 0, maxSpeed, false);
        this.model = model;
        this.batteryCapacity = batteryCapacity;
        this.hasPlaidMode = hasPlaidMode;
        this.hasDogMode = hasDogMode;
        this.hasFartMode = hasFartMode;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public boolean isHasPlaidMode() {
        return hasPlaidMode;
    }

    public boolean isHasDogMode() {
        return hasDogMode;
    }

    public boolean isHasFartMode() {
        return hasFartMode;
    }

    @Override
    public void setCurrentGear(int currentGear) {
        System.out.println("There are no gears!, it's a Tesla (facepalm)");
        return;
    }

    @Override
    public int getGears() {
        System.out.println("There are no gears!, it's a Tesla (facepalm)");
        return super.getGears();
    }
    
}
