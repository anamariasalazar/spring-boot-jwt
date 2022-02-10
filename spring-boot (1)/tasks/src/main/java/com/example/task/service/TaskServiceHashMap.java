package com.example.task.service;

import com.example.task.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceHashMap implements TaskService {
    private final HashMap<String, Task> taskHashMap = new HashMap<>();

    @Override
    public Boolean create(Task task) {
        try {
            taskHashMap.put(task.getId(), task);
            return true;
        }catch (Exception e){
            return false;
        }    }

    @Override
    public Task findById(String id) {
        return taskHashMap.get(id);
    }

    @Override
    public List<Task> getAll() {
        ArrayList<Task> tasks = new ArrayList<>(taskHashMap.values());
        return new ArrayList<Task>(taskHashMap.values());
    }

    @Override
    public Boolean deleteById(String id) {
        try{
            taskHashMap.remove(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(Task task, String id) {
        try {
            taskHashMap.put(id,task);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String next(){
        ArrayList<String> keys = new ArrayList<>(taskHashMap.keySet());
        String id="1";
        if (keys.size()>0){
            id = String.valueOf(Integer.parseInt(keys.get(keys.size()-1))+1);
        }
        return id;
    }

}
