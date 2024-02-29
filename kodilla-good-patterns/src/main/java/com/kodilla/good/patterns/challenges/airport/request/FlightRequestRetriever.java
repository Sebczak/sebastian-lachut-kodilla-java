package com.kodilla.good.patterns.challenges.airport.request;

public class FlightRequestRetriever {

    public FlightRequest retrieveData() {
        String departureCity = "Wroclaw";
        String destinationCity = "Krakow";

        return new FlightRequest(departureCity,  destinationCity);
    }
}
