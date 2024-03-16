package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> sudokuElements = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            sudokuElements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                result.append("| ");
            }
            result.append(sudokuElements.get(i)).append(" ");
        }
        return result.toString();
    }
}