package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        System.out.println("Modul 6. Wprowadzenie do testowania oprogramowania");
        System.out.println("Modul 6.2 TDD");
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Module 6.2 Excercise");
        Calculator calculator = new Calculator(5,6);

        if(calculator.add() == 11) {
            System.out.println("Correct result");
        } else {
            System.out.println("Incorrect result");
        }

        if(calculator.subtract() == -1) {
            System.out.println("Correct result");
        } else {
            System.out.println("Incorrect result");
        };
    }
}
