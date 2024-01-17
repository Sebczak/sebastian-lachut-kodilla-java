package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName(
            "when numbers List is empty " +
            "then the result should be true"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();

        //When
        oddNumbersExterminator.exterminate(numbers);
        System.out.println("List is empty" + numbers);

        //Then
        Assertions.assertTrue(numbers.isEmpty());
    }

    @DisplayName(
            "when exterminate method is used on numbers " +
            "then returns evenList of numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(2, 3, 4, 5, 6, 7));

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        List<Integer> evenNumbers = oddNumbersExterminator.getEvenNumbers();
        System.out.println("Result List is " + result + " and evenNumbers List is " + evenNumbers);

        //Given
        Assertions.assertEquals(evenNumbers, result);
    }
}
