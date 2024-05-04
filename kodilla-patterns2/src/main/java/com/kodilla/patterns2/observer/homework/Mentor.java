package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {

    private String name;
    private int homeworkToCheck;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update(Homework homework) {
        System.out.println(getName() + " New Task to check in: " + homework.getHomeworkTopic() +
                "\n total " + getHomeworkToCheck() + " tasks to check");
        ++homeworkToCheck;
    }

    public String getName() {
        return name;
    }

    public int getHomeworkToCheck() {
        return homeworkToCheck;
    }
}
