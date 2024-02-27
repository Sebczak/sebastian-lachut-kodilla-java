package com.kodilla.good.patterns.challenges.airport.request;

public class FlightRequestRetriever {

    public FlightRequest retrieveData() {
        String departureCity = "Gdańsk";
        String planeStopCity = "Wrocław";
        String destinationCity = "Warszawa";

        return new FlightRequest(departureCity, planeStopCity,  destinationCity);
    }
}
