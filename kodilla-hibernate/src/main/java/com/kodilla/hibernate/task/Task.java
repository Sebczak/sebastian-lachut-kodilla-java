package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {

    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private TaskList taskList;

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "created")
    @NotNull
    public Date getCreated() {
        return created;
    }

    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "tasks_financials_id")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "tasklist_id")
    public TaskList getTaskList() { return taskList; }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}
