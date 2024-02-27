package com.kodilla.good.patterns.challenges.airport.request;

public class FlightRequest {

    private String departureCity;
    private String destinationCity;
    private String planeStopCity;

    public FlightRequest(String departureCity, String planeStopCity, String destinationCity) {
        this.departureCity = departureCity;
        this.planeStopCity = planeStopCity;
        this.destinationCity = destinationCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getPlaneStopCity() {
        return planeStopCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }
}
