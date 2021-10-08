package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        // Room components
        Windows windows = new Windows("double-hung", "roller");
        Lighting lighting = new Lighting("general", "lightblue");
        ClimateControl climateControl = new ClimateControl();

        // Room
        Room room = new Room(new Dimensions(6,10,4),
                "laminate", true, lighting, windows,
                climateControl);

        // Room functionality
        System.out.println("Room width = " + room.getDimensions().getWidth() + " meters");
        System.out.println("Room length = " + room.getDimensions().getLength() + " meters");
        System.out.println("Room height = " + room.getDimensions().getHeight() + " meters");

        System.out.println("Room flooring type = " + room.getFloorMaterial());
        System.out.println("Room flooring is soundproof: " + room.isFloorSoundproof());

        System.out.println("Room windows type = " + room.getWindows().getWindowsType());
        System.out.println("Room window blinds type = " + room.getWindows().getBlindsType());
        room.getWindows().openWindows();
        room.getWindows().closeWindows();
        room.getWindows().closeWindows();
        room.getWindows().closeBlinds();
        room.getWindows().openBlinds();
        room.getWindows().openBlinds();

        System.out.println("Current lighting type = " + room.getLighting().getType());
        System.out.println("Current color type = " + room.getLighting().getColor());
        room.getLighting().hitSwitch();
        room.getLighting().changeType("ambient");
        room.getLighting().changeColor("red");
        room.getLighting().hitSwitch();
        room.getLighting().hitSwitch();
        room.hitLightSwitch();

        System.out.println("Current climate control temperature is set to " +
                room.getClimateControl().getTemperature());
        System.out.println("Climate control is currently turned on: " +
                room.getClimateControl().isOn());
        room.getClimateControl().pressPowerButton();
        room.getClimateControl().setTemperature(22);
        room.getClimateControl().pressPowerButton();


    }
}
