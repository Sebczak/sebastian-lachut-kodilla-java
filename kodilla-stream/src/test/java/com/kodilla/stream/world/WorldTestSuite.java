package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        List<Country> countries = new ArrayList<>();
        List<Continent> continents = new ArrayList<>();
        Country poland = new Country("Poland", new BigDecimal("500"));
        Country sweden = new Country("Sweden", new BigDecimal("400"));
        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(sweden);

        Country china = new Country("China", new BigDecimal("300"));
        Country india = new Country("India", new BigDecimal("200"));
        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        assertEquals(new BigDecimal("1400"), totalPeople);
    }
}
