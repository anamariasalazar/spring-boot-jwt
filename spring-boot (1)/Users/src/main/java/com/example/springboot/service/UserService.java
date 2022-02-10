package com.example.springboot.service;

import com.example.springboot.data.User;
import com.example.springboot.dto.UserDto;

import java.util.List;

public interface UserService {

    Boolean create( User user );
    User findById(String id );
    List<User> getAll();
    Boolean deleteById( String id );
    Boolean update(String userId,User user);
    String next();
}
