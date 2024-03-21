package com.kodilla.sudoku;

import com.kodilla.messages.Messages;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private final List<SudokuRow> sudokuBoard = new ArrayList<>();

    public SudokuBoard() {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            sudokuBoard.add(new SudokuRow());
        }
    }

    public void setValueInBoard(int col, int row, int value) {
        sudokuBoard.get(col).getSudokuRow().get(row).setValue(value);
    }


    public SudokuRow getRow(int index) {
        if (index < Messages.MIN_INDEX || index >= Messages.MAX_INDEX) {
            throw new IllegalArgumentException(Messages.ROW_INDEX_OUT_OF_BOUNDS);
        }
        return sudokuBoard.get(index);
    }

    public SudokuElement getElement(int row, int col) {
        if (row < Messages.MIN_INDEX || row >= Messages.MAX_INDEX || col < Messages.MIN_INDEX || col >= Messages.MAX_INDEX) {
            throw new IllegalArgumentException(Messages.ROW_OR_COLUMN_INDEX_OUT_OF_BOUNDS);
        }
        return sudokuBoard.get(row).getSudokuRow().get(col);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            if (i % 3 == Messages.MIN_INDEX && i != Messages.MIN_INDEX) {
                result.append("---------+----------+---------\n");
            }
            for (int j = Messages.MIN_INDEX; j < Messages.MAX_INDEX; j++) {
                if (j % 3 == Messages.MIN_INDEX && j != Messages.MIN_INDEX) {
                    result.append("| ");
                }
                SudokuElement element = sudokuBoard.get(i).getSudokuRow().get(j);
                int value = element.getValue();
                if (value > Messages.MIN_INDEX) {
                    result.append(" ");
                }
                result.append(value < 0 ? " X " : value + " ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
