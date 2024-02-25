package com.kodilla.good.patterns.challenges.airport.request;

public class FlightRequestRetriever {

    public FlightRequest retrieveData() {
        String departureCity = "Gdańsk";
        String destinationCity = "Wrocław";

        return new FlightRequest(departureCity, destinationCity);
    }
}
