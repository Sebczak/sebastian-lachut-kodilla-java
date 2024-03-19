package com.kodilla.sudoku;

import com.kodilla.messages.Messages;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> sudokuRow = new ArrayList<>();

    public SudokuRow() {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            sudokuRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            if (i % 3 == Messages.MIN_INDEX && i != Messages.MIN_INDEX) {
                result.append("| ");
            }
            result.append(sudokuRow.get(i)).append(" ");
        }
        return result.toString();
    }
}