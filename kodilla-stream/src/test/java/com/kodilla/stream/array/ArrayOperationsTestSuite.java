package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void ArrayOperations() {
        //Given
        int[] numbers = {1,2,3,4,5,6,6,6,1,2,3,5,4,3};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(3.6, result, 0.1);
    }
}
