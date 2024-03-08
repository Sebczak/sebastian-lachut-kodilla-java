package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {

    private TaskFactory taskFactory;
    private boolean switchExecute;

    @BeforeEach
    public void seyUp() {
        taskFactory = new TaskFactory();
    }

    @Test
    void testCreatingDrivingTask() {
        //Given

        //When
        Task drivingTask = taskFactory.createTasks(TaskName.DRIVING_TASK);
        switchExecute = drivingTask.isTaskExecuted();

        //Then
        assertTrue(switchExecute);
        assertEquals("Food delivery", drivingTask.getTaskName());
        assertEquals("Warsaw", ((DrivingTask) drivingTask).getWhere());
        assertEquals("Car", ((DrivingTask) drivingTask).getUsing());
    }

    @Test
    void testCreatingPaintingTask() {
        //Given

        //When
        Task paintingTask = taskFactory.createTasks(TaskName.PAINTING_TASK);
        switchExecute = paintingTask.isTaskExecuted();

        //Then
        assertTrue(switchExecute);
        assertEquals("Painting walls", paintingTask.getTaskName());
        assertEquals("Walls", ((PaintingTask) paintingTask).getWhatToPaint());
        assertEquals("Red", ((PaintingTask) paintingTask).getColor());
    }

    @Test
    void testCreatingShoppingTask() {
        //Given

        //When
        Task shoppingTask = taskFactory.createTasks(TaskName.SHOPPING_TASK);
        switchExecute = shoppingTask.isTaskExecuted();

        //Then
        assertTrue(switchExecute);
        assertEquals("Buying groceries", shoppingTask.getTaskName());
        assertEquals("Apples", ((ShoppingTask) shoppingTask).getWhatToBuy());
        assertEquals(10, ((ShoppingTask) shoppingTask).getQuantity());
    }
}
