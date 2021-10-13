package kiro.javaCore;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel > -1 && tonerLevel < 101 ? tonerLevel : -1;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (tonerLevel + tonerAmount > 100)
                return -1;
            tonerLevel += tonerAmount;
            return tonerLevel;
        }
        return -1;
    }

    public int printPages(int pages) {
        if (pages <= 0)
            return -1;

        int pagesToPrint = pages;
        if (duplex) {
            System.out.println("Printing mode: duplex");
            pagesToPrint = pagesToPrint / 2 + pagesToPrint % 2;
        } else {
            System.out.println("Printing mode: simplex");
        }

        pagesPrinted += pagesToPrint;
        System.out.println("Printing " + pagesToPrint + " pages");
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
