package com.example.mypackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Forum Cinema", 8, 12);
        theatre.reserveSeat("A02");
        theatre.reserveSeat("E09");
        theatre.reserveSeat("B13");

        printList(theatre.getSeats());

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        // sorting using the static comparator
        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

    public static void printList(List<? extends Theatre.Seat> list) {
        System.out.println("======================================================");

        for (Theatre.Seat seat : list) {
            System.out.println(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }

        System.out.println("======================================================");
    }
}
