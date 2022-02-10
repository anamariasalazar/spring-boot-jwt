package com.example.springboot.service;

import com.example.springboot.data.User;
import com.example.springboot.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceHashMap implements UserService{
    private final HashMap<String, User> userHashMap = new HashMap<>();

    @Override
    public Boolean create(User user) {
        try {
            userHashMap.put(user.getId(), user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public User findById(String id) {
        return userHashMap.get(id);
    }

    @Override
    public List<User> getAll() {
        ArrayList<User> users = new ArrayList<>(userHashMap.values());
        return users;
    }

    @Override
    public Boolean deleteById(String id) {
        try {
            userHashMap.remove(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean update(String userId,User user) {
        try {
            userHashMap.put(userId,user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String next(){
        ArrayList<String> keys = new ArrayList<>(userHashMap.keySet());
        String id="1";
        if (keys.size()>0){
            id = String.valueOf(Integer.parseInt(keys.get(keys.size()-1))+1);
        }
        return id;
    }
}
