package com.tasker.todolist.utils;

public class GeneratedId {
    private Integer count = 1;

    public  Integer nextId(){
        return count++;
    }
}
