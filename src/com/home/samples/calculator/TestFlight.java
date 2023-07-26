package com.home.samples.calculator;

public class TestFlight {
    int flightNumber;
    {
        flightNumber = 0;
    }

    TestFlight() {}
    TestFlight(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    int getFlightNumber() {
        return this.flightNumber;
    }

    void changeFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    boolean compareFlight(Object o) {
        if (!(o instanceof TestFlight)) {
            return false;
        }
        TestFlight flight = (TestFlight) o;
        return this.getFlightNumber() == flight.getFlightNumber();
    }
}
