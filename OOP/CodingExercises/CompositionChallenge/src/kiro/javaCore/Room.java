package kiro.javaCore;

public class Room {

    private Dimensions dimensions;
    private Flooring flooring;
    private Lighting lighting;
    private Windows windows;
    private ClimateControl climateControl;

    public Room(Dimensions dimensions, String floorMaterial,
                boolean isFloorSoundproof, Lighting lighting,
                Windows windows, ClimateControl climateControl) {
        this.dimensions = dimensions;
        this.flooring = new Flooring(dimensions.getWidth(), dimensions.getLength(),
                floorMaterial, isFloorSoundproof);
        this.lighting = lighting;
        this.windows = windows;
        this.climateControl = climateControl;
    }

    // Directly accessible composition
    public Dimensions getDimensions() {
        return dimensions;
    }

    public Lighting getLighting() {
        return lighting;
    }

    public Windows getWindows() {
        return windows;
    }

    public ClimateControl getClimateControl() {
        return climateControl;
    }

    // Hidden composition
    public String getFloorMaterial() {
        return flooring.getMaterial();
    }

    public boolean isFloorSoundproof() {
        return flooring.isSoundproof();
    }

    // Additional composition functionality
    public void hitLightSwitch() {
        lighting.hitSwitch();
    }
}
