package com.tasker.todolist.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private  String name;
    @Column
    private  String discription;
    @Column
    private LocalDate date;
    @Column
    private boolean completed = false;

    public Task() {}


    public Long getId() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return completed == task.completed && Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(discription, task.discription) && Objects.equals(date, task.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, discription, date, completed);
    }

    @PrePersist
    public void prePersist(){
        date = LocalDate.now();
    }
}
