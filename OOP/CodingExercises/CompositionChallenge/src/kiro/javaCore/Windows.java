package kiro.javaCore;

public class Windows {

    private String type;
    private boolean isOpen;
    private Blinds blinds;

    public Windows(String windowsType, String blindsType) {
        this.type = windowsType;
        this.isOpen = false;
        this.blinds = new Blinds(blindsType);
    }

    public void openWindows() {
        if (isOpen) {
            System.out.println("Windows are already open;");
        } else {
            isOpen = true;
            System.out.println("Windows are now open;");
        }
    }

    public void closeWindows() {
        if (!isOpen) {
            System.out.println("Windows are already closed;");
        } else {
            isOpen = false;
            System.out.println("Windows are now closed;");
        }
    }

    public String getWindowsType() {
        return type;
    }

    public boolean isWindowsOpen() {
        return isOpen;
    }

    // Hidden Blinds composition

    public void openBlinds() {
        blinds.open();
    }

    public void closeBlinds() {
        blinds.shut();
    }

    public String getBlindsType() {
        return blinds.getType();
    }

    public boolean isBlindsOpen() {
        return !blinds.isShut();
    }
}
