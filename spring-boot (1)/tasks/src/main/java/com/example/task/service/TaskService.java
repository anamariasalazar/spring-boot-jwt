package com.example.task.service;

import com.example.task.data.Task;
import com.example.task.dto.TaskDto;

import java.util.List;

public interface TaskService {
    Task create(Task task );

    Task findById( String id );

    List<Task> getAll();

    void deleteById( String id );

    Task update(TaskDto taskDto, String id );

    Integer next();
}
