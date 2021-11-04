package com.example.mypackage;

import java.util.*;

public class Theatre {

    private final String name;
    private List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER;

    static {
        // ordering not consistent with equals with current definition;
        // possible problems with ordered sets and maps;
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                return ((Double) (seat1.getPrice())).compareTo(seat2.getPrice());
            }
        };
    }

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;

        int lastRow = 'A' + (numRows - 1);
        for (char row  = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;

                if (row < 'D' && seatNum >= 4 && seatNum <= seatsPerRow - 3)
                    price = 14.00;
                else if (row > 'F' || seatNum < 4 || seatNum > seatsPerRow - 3) {
                    price = 7.00;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }


    public boolean reserveSeat(String seatNumber) {
        // binary search is more efficient
        int foundSeat = Collections.binarySearch(seats, new Seat(seatNumber, 0), null);
        if (foundSeat < 0) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return seats.get(foundSeat).reserve();
    }

    // for testing
    public List<Seat> getSeats() {
        return seats;
    }

    class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;
        private double price;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
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

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        // to be able to call binary search, you need to implement Comparable<Seat>
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
