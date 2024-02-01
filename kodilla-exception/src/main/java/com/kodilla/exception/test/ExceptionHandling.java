package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 1));
        } catch (Exception e) {
            System.out.println("Exception found");
        }

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2, 1));
        } catch (Exception e) {
            System.out.println("X value is at least 2 " + e.getMessage());
        }

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(-1, 1));
        } catch (Exception e) {
            System.out.println("X value is lower than 1 " + e.getMessage());
        }

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 1.5));
        } catch (Exception e) {
            System.out.println("Y value equals 1.5 " + e.getMessage());
        } finally {
            System.out.println("Stop");
        }

        Flight warsawToCracow = new Flight("Warsaw", "Cracow");
        Flight nairobiToOslo = new Flight("Nairobi", "Oslo");

        FlightSearch flightSearch = new FlightSearch();

        try {
            flightSearch.findFlight(warsawToCracow);
        } catch (RouteNotFoundException e) {
            System.out.println("Flight is not available");
        }

        try {
            flightSearch.findFlight(nairobiToOslo);
        } catch (RouteNotFoundException e) {
            System.out.println("Flight is not available");
        }


    }
}
