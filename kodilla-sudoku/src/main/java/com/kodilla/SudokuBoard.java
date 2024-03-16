package com.kodilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuBoard {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }

    public void setValueInList(int col, int row, int value) {
        sudokuRows.get(col).getSudokuElements().get(row).setValue(value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < MAX_INDEX; i++) {
            if (i % 3 == 0 && i != 0) {
                result.append("---------+----------+---------\n");
            }
            for (int j = 0; j < MAX_INDEX; j++) {
                if (j % 3 == 0 && j != 0) {
                    result.append("| ");
                }
                SudokuElement element = sudokuRows.get(i).getSudokuElements().get(j);
                int value = element.getValue();
                if (value > 0) {
                    result.append(" ");
                }
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public List<SudokuRow> getSudokuRows() {
        return sudokuRows;
    }
}
