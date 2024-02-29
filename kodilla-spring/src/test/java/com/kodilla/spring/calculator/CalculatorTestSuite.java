package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given

        //When
        Double addingResult = calculator.add(2,3);
        Double subtractResult = calculator.sub(2,3);
        Double multiplyResult = calculator.mul(2,3);
        Double divideBy0Result = calculator.div(2,0);
        Double divideResult = calculator.div(2,4);

        //Then
        assertEquals(5, addingResult);
        assertEquals(-1, subtractResult);
        assertEquals(6, multiplyResult);
        assertEquals(1, divideBy0Result);
        assertEquals(0.5, divideResult);
    }
}
