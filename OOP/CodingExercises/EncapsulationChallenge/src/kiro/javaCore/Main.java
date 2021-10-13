package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	// Demonstrating proper encapsulation techniques

        Printer simplexPrinter = new Printer(100, false);

        simplexPrinter.printPages(40, false);
        System.out.println("simplexPrinter.tonerLevel = " +
                simplexPrinter.getTonerLevel());
        System.out.println("simplexPrinter.totalPagesPrinted = " +
                simplexPrinter.getTotalPagesPrinted());
        System.out.println();

        simplexPrinter.printPages(30, true);
        System.out.println("simplexPrinter.tonerLevel = " +
                simplexPrinter.getTonerLevel());
        System.out.println("simplexPrinter.totalPagesPrinted = " +
                simplexPrinter.getTotalPagesPrinted());
        System.out.println();

        simplexPrinter.printPages(40, false);
        System.out.println("simplexPrinter.tonerLevel = " +
                simplexPrinter.getTonerLevel());
        System.out.println("simplexPrinter.totalPagesPrinted = " +
                simplexPrinter.getTotalPagesPrinted());
        simplexPrinter.fillUpToner();
        System.out.println();


        Printer duplexPrinter = new Printer(100, true);

        duplexPrinter.printPages(50, true);
        System.out.println("duplexPrinter.tonerLevel = " +
                duplexPrinter.getTonerLevel());
        System.out.println("duplexPrinter.totalPagesPrinted = " +
                duplexPrinter.getTotalPagesPrinted());
        System.out.println();

        duplexPrinter.printPages(80, false);
        System.out.println("duplexPrinter.tonerLevel = " +
                duplexPrinter.getTonerLevel());
        System.out.println("duplexPrinter.totalPagesPrinted = " +
                duplexPrinter.getTotalPagesPrinted());
        duplexPrinter.fillUpToner();
        System.out.println();

    }
}
