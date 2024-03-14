package com.kodilla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuBoard {

    public final static int MIN_INDEX = 0;
    public final static int MAX_INDEX = 9;
    private List<SudokuRow> sudokuRow = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < 3; i++) {
            sudokuRow.add(new SudokuRow());
        }

        shuffleValuesInRows();
    }

    private void shuffleValuesInRows() {
        for (SudokuRow row : sudokuRow) {
            Collections.shuffle(row.getSudokuCol());
        }
    }

    @Override
    public String toString() {
        String result = "";
        SudokuRow row = sudokuRow.get(0);

        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            for (int j = MIN_INDEX; j < MAX_INDEX; j++) {
                result += "|" + row;
            }
            result += "|\n";
        }
        return result;
    }

}
