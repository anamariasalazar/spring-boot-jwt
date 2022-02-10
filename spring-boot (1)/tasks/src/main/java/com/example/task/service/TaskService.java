package com.example.task.service;

import com.example.task.data.Task;

import java.util.List;

public interface TaskService {
    Boolean create(Task task );

    Task findById( String id );

    List<Task> getAll();

    Boolean deleteById( String id );

    Boolean update(Task task, String id );

    String next();
}
