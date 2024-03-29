package com.kodilla.sudoku;

import com.kodilla.input.Scanner;
import com.kodilla.messages.Messages;
import com.kodilla.output.ConsoleOut;

import static com.kodilla.messages.Messages.SAMPLE_DATA;

public class SudokuGame {
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private final SudokuSolver sudokuSolver = new SudokuSolver();
    private final Scanner scanner;
    private final ConsoleOut consoleOut;

    public SudokuGame() {
        this(new Scanner(), new ConsoleOut());
    }

    public SudokuGame(Scanner scanner, ConsoleOut consoleOut) {
        this.scanner = scanner;
        this.consoleOut = consoleOut;

    }

    private void sampleDataForSudoku() {
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
        boolean isGameFinished = true;

        while (isGameFinished) {
            sudokuBoard = new SudokuBoard();
            System.out.println(sudokuBoard);
            useSampleDataOrPlayerInputInBoard();
            if (sudokuSolver.solveBoard(sudokuBoard)) {
                consoleOut.println(Messages.SUDOKU_SOLVED_SUCCESSFULLY);
                System.out.println(sudokuBoard);
            } else {
                consoleOut.println(Messages.SUDOKU_NOT_SOLVED);
                System.out.println(sudokuBoard);
            }
            consoleOut.println(Messages.ASK_FOR_PLAY_AGAIN);
            String playAgainInput = scanner.nextLine();
            isGameFinished = playAgainInput.equalsIgnoreCase(Messages.YES);
        }
    }

    private void useSampleDataOrPlayerInputInBoard() {
        consoleOut.println(Messages.ASK_FOR_SAMPLE_DATA);
        String playerInputForSampleDataOrPlayerCustomInputs = scanner.nextLine();
        if (playerInputForSampleDataOrPlayerCustomInputs.equals(SAMPLE_DATA)) {
            sampleDataForSudoku();
        } else {
            consoleOut.println(Messages.HOW_MANY_INPUTS);
            int howManyInputs = scanner.nextInt();
            for (int i = 0; i < howManyInputs; i++) {
                consoleOut.println(Messages.COLUMN);
                int col = scanner.nextInt() - 1;
                consoleOut.println(Messages.ROW);
                int row = scanner.nextInt() - 1;
                consoleOut.println(Messages.VALUE);
                int value = scanner.nextInt();
                scanner.nextLine();
                sudokuBoard.setValueInBoard(col, row, value);
                System.out.println(sudokuBoard);
            }
        }
    }
}