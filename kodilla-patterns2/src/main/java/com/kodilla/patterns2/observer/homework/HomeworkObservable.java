package com.kodilla.patterns2.observer.homework;


public interface HomeworkObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
