package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Figure {

    private final String name;
    private final List<Figure> winningAgainst = new ArrayList<>();

    public Figure(String name) {
        this.name = name;
    }

    public void addWinningAgainstFigure(Figure figure) {
        winningAgainst.add(figure);
    }

    public boolean checkIfsWinningAgainst(Figure figure) {
        return winningAgainst.contains(figure);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(name, figure.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public List<Figure> getWinningAgainst() {
        return winningAgainst;
    }
}
