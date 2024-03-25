package com.kodilla.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Integer[] arr = {31,1,5,2,3,6,8,10,15};
        System.out.println(main.returnSecondMinValueFromArray(arr));
        System.out.println(main.returnSecondMaxValueFromArray(arr));

    }
//31,1,5,2,3,6,8,10,15
    public Integer returnSecondMinValueFromArray(Integer[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (Integer integer : arr) {
            if (integer < firstMin) {
                secondMin = firstMin;
                firstMin = integer;
            } else if (integer < secondMin && integer != firstMin) {
                secondMin = integer;
            }
        }
        return secondMin;
    }

    public Integer returnSecondMaxValueFromArray(Integer[] arr) {
        int firstMin = Integer.MIN_VALUE;
        int secondMin = Integer.MIN_VALUE;

        for (Integer integer : arr) {
            if (integer > firstMin) {
                secondMin = firstMin;
                firstMin = integer;
            } else if (integer > secondMin && integer != firstMin) {
                secondMin = integer;
            }
        }
        return secondMin;
    }
}
