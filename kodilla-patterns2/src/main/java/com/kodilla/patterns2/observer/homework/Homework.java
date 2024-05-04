package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Homework implements HomeworkObservable {

    private List<Observer> observers;
    private List<String> homeworks;
    private String homeworkTopic;

    public Homework(String homeworkTopic) {
        observers = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.homeworkTopic = homeworkTopic;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getHomeworkTopic() {
        return homeworkTopic;
    }
}
