package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {

    public void displayValues(double val) {
        System.out.println(val);
    }
}
