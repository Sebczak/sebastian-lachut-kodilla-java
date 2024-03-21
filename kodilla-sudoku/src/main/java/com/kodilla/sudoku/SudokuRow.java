package com.kodilla.sudoku;

import com.kodilla.messages.Messages;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private final List<SudokuElement> sudokuRow = new ArrayList<>();

    public SudokuRow() {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            sudokuRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}