package com.kodilla.rps;

public class WinnerChecker {
    private final Figure figureRock = new Figure("Rock");
    private final Figure figurePaper = new Figure("Paper");
    private final Figure figureScissors = new Figure("Scissors");
    private final Figure figureLizard = new Figure("Lizard");
    private final Figure figureSpock = new Figure("Spock");

    public WinnerChecker() {
    }

    protected Player checkWinner(String[] choices, Player p1, Player com) {
        Figure playerChoice = getFigureFromIndex(p1.getChoice());
        Figure comChoice = getFigureFromIndex(com.getChoice());
        System.out.println("Player's choice: " + choices[p1.getChoice()]);
        System.out.println("COM's choice: " + choices[com.getChoice()]);

        if (playerChoice.equals(comChoice)) {
            return null;
        } else if (playerChoice.checkIfsWinningAgainst(comChoice)) {
            p1.incrementScore();
            return p1;
        } else {
            com.incrementScore();
            return com;
        }
    }

    protected Figure getFigureFromIndex(int index) {
        return switch (index) {
            case 0 -> figureRock;
            case 1 -> figurePaper;
            case 2 -> figureScissors;
            case 3 -> figureLizard;
            case 4 -> figureSpock;
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }

    protected void playerBeatsCom() {
        figureRock.addWinningAgainstFigure(figureScissors);
        figureRock.addWinningAgainstFigure(figureLizard);

        figurePaper.addWinningAgainstFigure(figureRock);
        figurePaper.addWinningAgainstFigure(figureSpock);

        figureScissors.addWinningAgainstFigure(figurePaper);
        figureScissors.addWinningAgainstFigure(figureLizard);

        figureLizard.addWinningAgainstFigure(figureSpock);
        figureLizard.addWinningAgainstFigure(figurePaper);

        figureSpock.addWinningAgainstFigure(figureScissors);
        figureSpock.addWinningAgainstFigure(figureRock);
    }
}
