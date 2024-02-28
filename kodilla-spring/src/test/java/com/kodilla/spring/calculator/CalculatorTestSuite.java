package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given

        //When
        calculator.add(2,3);
        calculator.sub(2,3);
        calculator.mul(2,3);
        calculator.div(2,0);
        calculator.div(2,3);
    }
}
