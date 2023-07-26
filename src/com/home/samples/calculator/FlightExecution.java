package com.home.samples.calculator;

public class FlightExecution {
    public static void main(String[] args) {
        TestFlight val1 = new TestFlight(10);
        TestFlight val2 = new TestFlight(10);
        // TestFlight val2 = val1;
        // val2.changeFlightNumber(225);
        // System.out.println(val1.flightNumber);
        // System.out.println(val2.flightNumber);

        // swapFlight(val1, val2);
        // compare Object Instances
        // using default equals method
        System.out.println(val1.equals(val2));

        // using custom compare method
        System.out.println(val1.compareFlight(val2));
        // swapFlightNumber(val1, val2);
        // System.out.println("Outside flight swap method");
        // System.out.println(val1.getFlightNumber());
        // System.out.println(val2.getFlightNumber());
    }
    static void swapFlight(TestFlight i, TestFlight j) {
        TestFlight k = i;
        i = j;
        j = k;
        System.out.println("Inside flight swap method");
        System.out.println(i.getFlightNumber());
        System.out.println(j.getFlightNumber());
    }

    static void swapFlightNumber(TestFlight i, TestFlight j) {
        int k = i.getFlightNumber();
        i.changeFlightNumber(j.getFlightNumber());
        j.changeFlightNumber(k);
    }
}
