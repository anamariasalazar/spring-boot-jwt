package com.example.springboot.service;

import com.example.springboot.data.User;
import com.example.springboot.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface UserService {

    Boolean create( User user );
    User findById(String id );
    List<User> getAll();
    Boolean deleteById( String id );
    Boolean update(String userId,User user);
    String next();
    List<User> findUsersLN (String queryText);
    List<User> findusercreatedafter (Date startDate);
    User findByEmail(String email);
}
