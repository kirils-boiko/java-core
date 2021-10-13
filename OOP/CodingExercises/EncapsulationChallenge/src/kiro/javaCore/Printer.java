package kiro.javaCore;

public class Printer {

    private int tonerLevel;     // kw private prevents unauthorized access
    private int totalPagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        // guaranteed initialization
        this.isDuplex = isDuplex;
        this.totalPagesPrinted = 0;
        if (tonerLevel >= 0 && tonerLevel <= 100)   // field validation
            this.tonerLevel = tonerLevel;
        else
            this.tonerLevel = 100;      // in percentage
    }

    public void fillUpToner() {
        tonerLevel = 100;
        System.out.println("Filling up the toner...");
        System.out.println("Current toner level: " + tonerLevel + "%");
    }

    public void printPages(int number, boolean duplex) {
        if (!isDuplex && duplex) {
            duplex = false;
            System.out.println("Warning: printer does not support duplex functionality;");
        }

        if (number < 0)
            number = 0;

        int pagesNotPrinted = 0;
        int pagesPrinted = 0;

        if (number > tonerLevel) {
            pagesNotPrinted = number - tonerLevel;
            pagesPrinted = tonerLevel;
            System.out.println("Warning: tonerLevel is insufficient for printing all pages");
        } else {
            pagesPrinted = number;
        }

        this.tonerLevel -= pagesPrinted;
        this.totalPagesPrinted += pagesPrinted;

        if (duplex) {
            System.out.println("Printing mode set to duplex");
        } else {
            System.out.println("Printing mode set to simplex");
        }

        System.out.println("Printing " + number + " pages...");
        System.out.println("Pages printed successfully: " + pagesPrinted);
        if (pagesNotPrinted > 0)
            System.out.println("Warning: pages not printed: " + pagesNotPrinted);

    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getTotalPagesPrinted() {
        return totalPagesPrinted;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
