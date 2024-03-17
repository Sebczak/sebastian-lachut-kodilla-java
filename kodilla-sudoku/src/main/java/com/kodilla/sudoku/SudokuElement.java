package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {

    public static final int EMPTY = -1;
    private int value;
    List<Integer> sudokuNumbers = new ArrayList<>();

    public SudokuElement() {
        this.value = EMPTY;
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

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
