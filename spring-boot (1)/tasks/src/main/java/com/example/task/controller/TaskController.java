package com.example.task.controller;

import com.example.task.data.Task;
import com.example.task.dto.TaskDto;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping( "/v1/task" )

public class TaskController {
    private final TaskService taskService;

    public TaskController(@Autowired TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<Task> findById(@PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Boolean> create( @RequestBody TaskDto taskDto ) {
        Task task = new Task(taskService.next(), taskDto);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Boolean> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        Task task = new Task(id,taskDto,taskService.findById(id).getCreated());
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteById(id));
    }
}
