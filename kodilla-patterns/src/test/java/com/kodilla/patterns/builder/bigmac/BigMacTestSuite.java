package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    void testCreateBurger() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .bun(BunType.CLASSIC)
                .burgers(3)
                .sauce(SauceType.KETCHUP)
                .ingredient(IngredientType.CHEESE)
                .ingredient(IngredientType.CHILLI_PEPPERS)
                .ingredient(IngredientType.CHAMPIGNONS)
                .build();

        //When
        System.out.println(bigMac);
        int amountOfIngredients = bigMac.getIngredients().size();

        assertEquals(3, amountOfIngredients);

    }
}
