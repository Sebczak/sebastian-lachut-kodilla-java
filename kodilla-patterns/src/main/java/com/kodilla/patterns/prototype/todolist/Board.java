package com.kodilla.patterns.prototype.todolist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Board extends Prototype<Board> {


    private String name;
    private Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = super.clone();
        clonedBoard.lists = new HashSet<>();
        for (TasksList tasksList : lists) {
            TasksList clonedList = new TasksList(tasksList.getName());
            for (Task task : tasksList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getLists().add(tasksList);
        }
        return clonedBoard;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "]\n";
        for (TasksList list : lists) {
            s = s + list.toString() + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name) &&
                Objects.equals(lists, board.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lists);
    }
}
