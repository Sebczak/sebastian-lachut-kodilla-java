package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    private List<Integer> evenNumbers = new ArrayList<>();

    public List<Integer> exterminate(List<Integer> numbers) {
        for(Integer num : numbers) {
            if(num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        return evenNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }
}
