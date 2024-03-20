package com.kodilla.hibernate.tasklist;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tasklists")
public class TaskList {

    private int id;
    private String listName;
    private String description;

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    public TaskList() {
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name ="id", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "listname")
    public String getListName() {
        return listName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
