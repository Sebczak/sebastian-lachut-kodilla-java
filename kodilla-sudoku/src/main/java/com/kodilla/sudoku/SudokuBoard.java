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


    private void removeValueFromRow(int row, int value) {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            if (i != row) {
                sudokuBoard.get(i).getSudokuRow().get(row).getSudokuNumbers().remove(Integer.valueOf(value));
            }
        }
    }

    private void removeValueFromColumn(int col, int value) {
        for (int i = 0; i < Messages.MAX_INDEX; i++) {
            if (i != col) {
                sudokuBoard.get(col).getSudokuRow().get(i).getSudokuNumbers().remove(Integer.valueOf(value));
            }
        }
    }

    private void removeValueFromBox(int col, int row, int value) {
        int startCol = col - (col % 3);
        int startRow = row - (row % 3);

        for (int i = startCol; i < startCol + 3; i++) {
            for (int j = startRow; j < startRow + 3; j++) {
                if (i != col && j != row) {
                    sudokuBoard.get(i).getSudokuRow().get(j).getSudokuNumbers().remove(Integer.valueOf(value));
                }
            }
        }
    }

    private boolean isValueInRow(int row, int value) {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            if (sudokuBoard.get(i).getSudokuRow().get(row).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(int col, int value) {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            if (sudokuBoard.get(col).getSudokuRow().get(i).getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInBox(int col, int row, int value) {
        int startCol = col - col % 3;
        int startRow = row - row % 3;

        for (int i = startCol; i < startCol + 3; i++) {
            for (int j = startRow; j < startRow + 3; j++) {
                if (sudokuBoard.get(i).getSudokuRow().get(j).getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(int col, int row, int value) {
        return !isValueInColumn(col,value) && !isValueInRow(row, value) && !isValueInBox(col, row, value);
    }

    public boolean solveBoard() {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            for (int j = Messages.MIN_INDEX; j < Messages.MAX_INDEX; j++) {
                if (sudokuBoard.get(i).getSudokuRow().get(j).getValue() == -1) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValidPlacement(i,j,k)) {
                            setValueInBoard(i,j,k);

                            if (solveBoard()) {
                                return true;
                            } else {
                                sudokuBoard.get(i).getSudokuRow().get(j).setValue(-1);
                            }
                        }
                    }
                    return false;
                }
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
