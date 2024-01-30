package com.kodilla.exception.test;

public class FirstChallange {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    public int optionalPow(int a, int b) {

        if (a == 0 && b > 0) {
            return 0;
        } else if (a != 0 && b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            int result = 1;

            for (int i = 1; i <= b; i++) {
                result *= a;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        FirstChallange firstChallange = new FirstChallange();

        try {
            double result = firstChallange.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0 ");
        } finally {
            System.out.println("Stop");
        }

        System.out.println(firstChallange.optionalPow(0,1));
    }
}