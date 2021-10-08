package kiro.javaCore;

public class Blinds {

    private String type;
    private boolean isShut;

    public Blinds(String type) {
        this.type = type;
        this.isShut = false;
    }

    public String getType() {
        return type;
    }

    public boolean isShut() {
        return isShut;
    }

    public void open() {
        if (isShut) {
            System.out.println("Window blinds are now open;");
            isShut = false;
        } else {
            System.out.println("Window blinds are already open;");
        }
    }

    public void shut() {
        if (isShut) {
            System.out.println("Window blinds are already shut;");
        } else {
            System.out.println("Window blinds are now shut;");
            isShut = true;
        }
    }
}
