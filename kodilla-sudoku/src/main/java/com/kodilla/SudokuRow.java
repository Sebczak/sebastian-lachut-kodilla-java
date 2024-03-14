package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private SudokuElement sudokuElement = new SudokuElement();

    List<SudokuElement> sudokuCol = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < 9; i++) {
            sudokuCol.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuCol() {
        return sudokuCol;
    }

    @Override
    public String toString() {
        return String.valueOf(sudokuElement.getNumberFromSudokuNumbers());
    }
}
