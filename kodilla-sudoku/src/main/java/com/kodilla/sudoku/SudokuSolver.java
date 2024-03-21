package com.kodilla.sudoku;

import com.kodilla.messages.Messages;

public class SudokuSolver {

    private boolean isValueInRow(SudokuBoard sudokuBoard, int row, int value) {
        SudokuRow sudokuRow = sudokuBoard.getRow(row);
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            SudokuElement element = sudokuRow.getSudokuRow().get(i);
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(SudokuBoard sudokuBoard, int col, int value) {
        for (int i = Messages.MIN_INDEX; i < Messages.MAX_INDEX; i++) {
            SudokuElement element = sudokuBoard.getElement(i, col);
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInBox(SudokuBoard sudokuBoard, int col, int row, int value) {
        int startCol = col - col % 3;
        int startRow = row - row % 3;

        for (int i = startCol; i < startCol + 3; i++) {
            for (int j = startRow; j < startRow + 3; j++) {
                SudokuElement element = sudokuBoard.getElement(j, i);
                if (element.getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(SudokuBoard sudokuBoard, int col, int row, int value) {
        return !isValueInColumn(sudokuBoard, col, value) && !isValueInRow(sudokuBoard, row, value) && !isValueInBox(sudokuBoard, col, row, value);
    }

    public boolean solveBoard(SudokuBoard sudokuBoard) {
        for (int row = Messages.MIN_INDEX; row < Messages.MAX_INDEX; row++) {
            for (int col = Messages.MIN_INDEX; col < Messages.MAX_INDEX; col++) {
                SudokuElement element = sudokuBoard.getElement(row, col);
                if (element.getValue() == -1) {
                    for (int value = 1; value <= Messages.MAX_INDEX; value++) {
                        if (isValidPlacement(sudokuBoard, col, row, value)) {
                            element.setValue(value);

                            if (solveBoard(sudokuBoard)) {
                                return true;
                            } else {
                                element.setValue(-1);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
