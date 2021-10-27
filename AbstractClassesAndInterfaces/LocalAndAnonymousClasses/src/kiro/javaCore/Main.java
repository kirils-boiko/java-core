package kiro.javaCore;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        // Local class (implementation of IOnClickListener nested interface)
        //  that exists only in the main method
        class ClickListener implements Button.IOnClickListener {
            public ClickListener() {
                System.out.println("Local class have been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

        btnPrint.setOnClickListener(new ClickListener());   // set local
        btnPrint.onClick();


        // Anonymous classes, declared and initialized at the same time
        //  no name - no reusability;

        btnPrint.setOnClickListener(new Button.IOnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked, anonymously");
            }
        });
        btnPrint.onClick();
    }
}
