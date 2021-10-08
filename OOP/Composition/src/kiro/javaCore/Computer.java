package kiro.javaCore;

public class Computer {

    // has-a relationships
    private Motherboard motherboard;
    private Case aCase;
    private Monitor monitor;

    public Computer(Motherboard motherboard, Case aCase, Monitor monitor) {
        this.motherboard = motherboard;
        this.aCase = aCase;
        this.monitor = monitor;
    }

    // Directly accessible composition
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
//
//    public Case getCase() {
//        return aCase;
//    }
//
//    public Monitor getMonitor() {
//        return monitor;
//    }

    // Hidden composition
    public void powerUp() {
        aCase.pressPowerButton();
        drawLogo();
    }

    public void loadProgram(String program) {
        motherboard.loadProgram(program);
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "aquablue");
    }
}
