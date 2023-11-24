package com.tasker.todolist.controllers;

import com.tasker.todolist.models.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @GetMapping(value = "/task/{name}/{discription}")
    public Task task(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "discription") String discription
            ){
        return new Task(name, discription);
    }
}
