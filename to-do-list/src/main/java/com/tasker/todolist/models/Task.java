package com.tasker.todolist.models;

import com.tasker.todolist.utils.GeneratedId;

import java.time.LocalDate;


public class Task {

    GeneratedId count = new GeneratedId();
    private Integer id;
    private final String name;
    private final String discription;
    private LocalDate date;
    private boolean completed = false;

    public Task(String name, String discription) {
        this.id =count.nextId();
        this.name = name;
        this.discription = discription;
        this.date = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isCompleted() {
        return completed;
    }
}
