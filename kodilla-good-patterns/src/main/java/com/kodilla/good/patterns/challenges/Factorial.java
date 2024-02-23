package com.kodilla.good.patterns.challenges;

public class Factorial {

    public int factorialCalculator (int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return result;
    }
}
