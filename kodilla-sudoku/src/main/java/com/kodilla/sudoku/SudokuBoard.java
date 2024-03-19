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


    private boolean solve(int row, int col) {
        if (row == Messages.MAX_INDEX) {
            row = 0;
            if (++col == Messages.MAX_INDEX) {
                return true;
            }
        }
        if (sudokuBoard.get(row).getSudokuRow().get(col).getValue() != -1) {
            return solve(row + 1, col);
        }
        for (int value = 1; value <= Messages.MAX_INDEX; ++value) {
            if (isValidPlacement(row, col, value)) {
                setValueInBoard(row, col, value);
                if (solve(row + 1, col)) {
                    return true;
                }
            }
        }
        setValueInBoard(row, col, -1);
        return false;
    }

    boolean solve() {
        return solve(0,0);
    }


    private boolean isValidMove(int row, int col, int value) {
        for (int i = 0; i < Messages.MAX_INDEX; i++) {
            if (sudokuBoard.get(row).getSudokuRow().get(i).getValue() == value) {
                return false;
            }
            if (sudokuBoard.get(i).getSudokuRow().get(col).getValue() == value) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudokuBoard.get(i).getSudokuRow().get(j).getValue() == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidPlacement(int row, int col, int value) {
        for (int i = 0; i < Messages.MAX_INDEX; ++i) {
            if (sudokuBoard.get(row).getSudokuRow().get(i).getValue() == value ||
                    sudokuBoard.get(i).getSudokuRow().get(col).getValue() == value ||
                    sudokuBoard.get(3 * (row / 3) + i / 3).getSudokuRow().get(3 * (col / 3) + i % 3).getValue() == value) {
                return false;
            }
        }
        return true;
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
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
