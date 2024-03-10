package com.kodilla;

public class FibonacciRecursive {
    public static void main(String[] args) {
        int fibonacciInput = 10;
        for (int i = 0; i < fibonacciInput; i++) {
            System.out.println(fibonacci(i));
        }
    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
