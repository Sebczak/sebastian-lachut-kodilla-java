package com.kodilla.spring.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class FibonacciAlgorithm {

    public static List<Integer> fibonacci(int range) {
        List<Integer> result = new ArrayList<>();
        int first = 0;
        int second = 1;

        for (int i = 0; i < range; i++) {
            result.add(first);
            int sumResult = (first + second);
            first = second;
            second = sumResult;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciAlgorithm.fibonacci(10);
    }
}
