package com.example.task.repository;

import com.example.task.data.Task;
import com.example.task.dto.TaskDto;
import com.example.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskMongoDB implements TaskService {

    private final TaskRepository taskRepository;

    public TaskMongoDB(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(TaskDto taskDto, String id) {
        Task task = taskRepository.findById(id).get();
        task.setAssignedTo(taskDto.getAssignedTo());
        task.setDescription(taskDto.getDescription());
        task.setName(taskDto.getName());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(taskDto.getDueDate());
        return taskRepository.save(task);
    }

    @Override
    public Integer next() {
        return Math.toIntExact(taskRepository.count() + 1);
    }
}
