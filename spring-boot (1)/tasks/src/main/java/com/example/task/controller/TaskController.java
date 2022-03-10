package com.example.task.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.task.data.Task;
import com.example.task.dto.TaskDto;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@RestController
@RequestMapping( "/v1/task" )

public class TaskController {
    private final TaskService taskService;
    public DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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
    public ResponseEntity<Task> create( @RequestBody TaskDto taskDto ) {
        String date = dateTimeFormatter.format(LocalDate.now());
        Task task = new Task(String.valueOf(taskService.next()), taskDto,date);
        return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));

    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Task> update( @RequestBody TaskDto taskDto, @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(taskDto,id));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        taskService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
