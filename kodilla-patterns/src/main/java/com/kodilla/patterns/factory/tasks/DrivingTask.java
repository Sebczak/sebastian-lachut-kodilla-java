package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean switchExecute;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
        this.switchExecute = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing driving task: " + getTaskName() + "\nDestination: " + getWhere() + "\nVehicle used: " + getUsing());
        switchExecute = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        switchExecute = !switchExecute;
        return switchExecute;
    }

    public String getWhere() {
        return where;
    }

    public String getUsing() {
        return using;
    }

    @Override
    public String toString() {
        return "DrivingTask{" +
                "taskName='" + taskName + '\'' +
                ", where='" + where + '\'' +
                ", using='" + using + '\'' +
                '}';
    }
}
