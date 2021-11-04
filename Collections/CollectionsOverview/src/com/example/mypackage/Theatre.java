package com.example.mypackage;


import com.example.binsearch.BinarySearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String name;
    private List<Seat> seats = new ArrayList<>();
    private final int seatsPerRow;

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;
        this.seatsPerRow = seatsPerRow;

        int lastRow = 'A' + (numRows - 1);
        for (char row  = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean reserveSeat(String seatNumber) {
//        Seat requestedSeat = null;
//        for (Seat seat : seats) {
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }

//        if (requestedSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestedSeat.reserve();

        // binary search is more efficient
        //int foundSeat = Collections.binarySearch(seats, new Seat(seatNumber), null);

        // custom binary search inspired by java.util.Collections
        int foundSeat = BinarySearch.binarySearch(seats, new Seat(seatNumber));
        if (foundSeat < 0) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return seats.get(foundSeat).reserve();
    }

    // for testing
    public void getSeats() {

        int count = 0;
        for (Seat seat : seats) {
            if (!seat.reserved)
                System.out.print(seat.getSeatNumber() + " ");
            else
                System.out.print("    ");
            count++;

            if (count == seatsPerRow) {
                count = 0;
                System.out.println();
            }
        }
    }

    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        // to be able to call binary search, you need to implement Comparable<Seat>
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!reserved) {
                System.out.println("Seat " + seatNumber + " reserved successfully");
                return reserved = true;
            }

            System.out.println("Seat " + seatNumber + " is already reserved");
            return false;
        }

        public boolean cancel() {
            if (this.reserved) {
                System.out.println("Seat " + seatNumber + " unreserved successfully");
                return !(reserved = false);
            }

            System.out.println("Seat " + seatNumber + " is not reserved");
            return false;
        }


    }
}
