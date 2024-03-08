package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private boolean switchExecute;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
        this.switchExecute = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing shopping task: " + taskName + "\nBought item: " + getWhatToBuy() + "\nQuantity: " + getQuantity());
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

    public String getWhatToBuy() {
        return whatToBuy;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ShoppingTask{" +
                "taskName='" + taskName + '\'' +
                ", whatToBuy='" + whatToBuy + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
