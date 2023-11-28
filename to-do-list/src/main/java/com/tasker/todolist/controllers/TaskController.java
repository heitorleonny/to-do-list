package com.tasker.todolist.controllers;

import com.tasker.todolist.models.Task;
import com.tasker.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task create(@RequestBody Task task){
        return taskService.createTask(task);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> findAll(){
        return taskService.fidAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task findById(
            @PathVariable(value = "id") Long id){
        return taskService.findById(id);
    }

   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task update(@RequestBody Task task){
        return taskService.update(task);
   }

   @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
   }

}
