package com.kodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuElement {

    public static final int EMPTY = -1;
    private int value = EMPTY;
    List<Integer> sudokuNumbers = new ArrayList<>();

    public SudokuElement() {
        sudokuNumbers.addAll(List.of(1,2,3,4,5,6,7,8,9));
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getSudokuNumbers() {
        return sudokuNumbers;
    }

    public Integer getNumberFromSudokuNumbers() {
        Random random = new Random();
        int rnd = random.nextInt(9);
        return getSudokuNumbers().get(rnd);
    }
}
