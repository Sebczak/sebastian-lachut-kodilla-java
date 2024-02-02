package com.kodilla.rps;

public class DetermineWinner {


    private final Player p1;
    private final Player com;

    public DetermineWinner(Player p1, Player com) {
        this.p1 = p1;
        this.com = com;
    }



    protected String checkWinner(String[] choices, int playerInput, int comInput) {
        System.out.println("Player's choice: " + choices[playerInput]);
        System.out.println("COM's choice: " + choices[comInput]);

        if (playerInput == comInput) {
            return "It's a tie.";
        } else if (playerBeatsCom(playerInput, comInput) ){
            p1.incrementScore();
            return "Player won a round";
        } else {
            com.incrementScore();
            return "Computer won a round";
        }
    }

    //Number clarification: 0 -> rock 1 -> paper 2 -> scissors 3 -> lizard 4 -> Spock
    private boolean playerBeatsCom(int winnerInput, int loserInput) {
        return switch (winnerInput) {
            case 0 -> loserInput == 2 || loserInput == 3;
            case 1 -> loserInput == 0 || loserInput == 4;
            case 2 -> loserInput == 1 || loserInput == 3;
            case 3 -> loserInput == 4 || loserInput == 1;
            case 4 -> loserInput == 2 || loserInput == 0;
            default -> false;
        };
    }

    protected int getWinningMove(String[] choices, int playerChoice) {
        int winningMove = 0;
        while (playerBeatsCom(winningMove, playerChoice)) {
            winningMove = (winningMove + 1) %choices.length;
        }
        return winningMove;
    }

    protected int getLosingMove(String[] choices, int playerChoice) {
        int losingMove = 0;
        while (playerBeatsCom(playerChoice, losingMove)) {
            losingMove = (losingMove + 1) % choices.length;
        }
        return losingMove;
    }
}
