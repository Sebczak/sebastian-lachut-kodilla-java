package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public Task createTasks(TaskName taskname) {
        return switch (taskname) {
            case DRIVING_TASK -> new DrivingTask("Food delivery", "Warsaw","Car");
            case PAINTING_TASK -> new PaintingTask("Painting walls", "Red", "Walls");
            case SHOPPING_TASK -> new ShoppingTask("Buying groceries","Apples",10);
        };
    }
}
