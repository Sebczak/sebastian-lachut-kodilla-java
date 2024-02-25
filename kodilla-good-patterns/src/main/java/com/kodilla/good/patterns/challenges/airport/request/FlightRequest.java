package com.kodilla.good.patterns.challenges.airport.request;

public class FlightRequest {

    private String departureCity;
    private String destinationCity;

    public FlightRequest(String departureCity, String destinationCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }
}
