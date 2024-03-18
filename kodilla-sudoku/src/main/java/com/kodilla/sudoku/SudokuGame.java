package com.kodilla.sudoku;

import com.kodilla.input.Scanner;
import com.kodilla.output.ConsoleOut;

public class SudokuGame {
    private final SudokuBoard sudokuBoard = new SudokuBoard();
    private final Scanner scanner = new Scanner();
    private final ConsoleOut consoleOut;

    public SudokuGame() {
        this(new ConsoleOut());
    }

    public SudokuGame(ConsoleOut consoleOut) {
        this.consoleOut = consoleOut;
    }

    public void sampleData() {
        sudokuBoard.setValueInBoard(1, 2, 8);
        sudokuBoard.setValueInBoard(0, 3, 2);
        sudokuBoard.setValueInBoard(0, 4, 6);
        sudokuBoard.setValueInBoard(0, 6, 7);
        sudokuBoard.setValueInBoard(0, 8, 1);
        sudokuBoard.setValueInBoard(1, 4, 7);
        sudokuBoard.setValueInBoard(1, 7, 9);
        sudokuBoard.setValueInBoard(2, 0, 1);
        sudokuBoard.setValueInBoard(2, 1, 9);
        sudokuBoard.setValueInBoard(2, 5, 4);
        sudokuBoard.setValueInBoard(2, 6, 5);
        sudokuBoard.setValueInBoard(3, 0, 8);
        sudokuBoard.setValueInBoard(3, 1, 2);
        sudokuBoard.setValueInBoard(3, 3, 1);
        sudokuBoard.setValueInBoard(3, 7, 4);
        sudokuBoard.setValueInBoard(4, 2, 4);
        sudokuBoard.setValueInBoard(4, 3, 6);
        sudokuBoard.setValueInBoard(4, 5, 2);
        sudokuBoard.setValueInBoard(4, 6, 9);
        sudokuBoard.setValueInBoard(5, 1, 5);
        sudokuBoard.setValueInBoard(5, 5, 3);
        sudokuBoard.setValueInBoard(5, 7, 2);
        sudokuBoard.setValueInBoard(5, 8, 8);
        sudokuBoard.setValueInBoard(6, 2, 9);
        sudokuBoard.setValueInBoard(6, 3, 3);
        sudokuBoard.setValueInBoard(6, 7, 7);
        sudokuBoard.setValueInBoard(6, 8, 4);
        sudokuBoard.setValueInBoard(7, 1, 4);
        sudokuBoard.setValueInBoard(7, 4, 5);
        sudokuBoard.setValueInBoard(7, 7, 3);
        sudokuBoard.setValueInBoard(7, 8, 6);
        sudokuBoard.setValueInBoard(8, 0, 7);
        sudokuBoard.setValueInBoard(8, 2, 3);
        sudokuBoard.setValueInBoard(8, 4, 1);
        sudokuBoard.setValueInBoard(8, 5, 8);
    }

    public void resolveSudoku() {
        boolean isGameFinished = false;

//            ConsoleOut.println(Messages.COLUMN);
//            int col = scanner.nextInt() - 1;
//            ConsoleOut.println(Messages.ROW);
//            int row = scanner.nextInt() - 1;
//            ConsoleOut.println(Messages.VALUE);
//            int value = scanner.nextInt();
        sampleData();
        System.out.println(sudokuBoard);
        if (sudokuBoard.solve()) {
            System.out.println("Sudoku");
            System.out.println(sudokuBoard);
        } else {
            System.out.println("Not sudoku");
        }
    }
}
