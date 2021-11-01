package com.example.mypackage;

import com.example.binsearch.BinarySearch;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Forum Cinema", 15, 15);
        theatre.getSeats();

        theatre.reserveSeat("E06");
        theatre.getSeats();

    }
}
