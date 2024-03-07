package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.customer.CorporateCustomer;
import com.kodilla.patterns.strategy.customer.Customer;
import com.kodilla.patterns.strategy.customer.IndividualCustomer;
import com.kodilla.patterns.strategy.customer.IndividualYoungCustomer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategy() {
        //Given
        Customer john = new IndividualYoungCustomer("John");
        Customer alex = new CorporateCustomer("Alex");
        Customer kate = new IndividualCustomer("Kate");

        //When
        String johnShouldBuy = john.predict();
        String alexShouldBuy = alex.predict();
        String kateShouldBuy = kate.predict();

        //Then
        assertEquals("Aggressive buy", johnShouldBuy);
        assertEquals("Balanced buy", alexShouldBuy);
        assertEquals("Conservative buy", kateShouldBuy);
    }

    @Test
    void testDefaultIndividualInvestingStrategy() {
        //Given
        Customer matt = new IndividualCustomer("Matt");

        //When
        String mattShouldBuy = matt.predict();

        //Then
        assertEquals("Conservative buy", mattShouldBuy);
    }
}
