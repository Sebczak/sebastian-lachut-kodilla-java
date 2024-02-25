package com.kodilla.good.patterns.challenges.airport.flight;

import java.util.Objects;

public class Flight {

    private String departureCity;
    private String destinationCity;

    public Flight(String departureCity, String arrivalCity) {
        this.departureCity = departureCity;
        this.destinationCity = arrivalCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureCity, flight.departureCity) && Objects.equals(destinationCity, flight.destinationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, destinationCity);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureCity='" + departureCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                '}';
    }
}
