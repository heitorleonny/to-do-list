package com.tasker.todolist.services;

import com.tasker.todolist.exceptions.ResourceNotFoundException;
import com.tasker.todolist.models.Task;
import com.tasker.todolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TaskService {

    private Logger logger = Logger.getLogger(TaskService.class.getName());
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        logger.info("Creating one task");
        return taskRepository.save(task);
    }


    public Task findById(Long id) {
        logger.info("Findind one task");
        return taskRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

    }

    public List<Task> fidAll(){
        logger.info("Findind all");
        return taskRepository.findAll();
    }

    public Task update(Task task){
        logger.info("Updating one task");
        var entity = taskRepository.findById(task.getId()) . orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        task.setName(task.getName());
        task.setDiscription(task.getDiscription());
        return taskRepository.save(task);

    }

    public void delete(Long id){
        logger.info("Deleting one task");
        var entity = taskRepository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        taskRepository.delete(entity);
    }
}
