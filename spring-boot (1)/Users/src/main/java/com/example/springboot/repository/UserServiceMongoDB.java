package com.example.springboot.repository;

import com.example.springboot.data.User;
import com.example.springboot.dto.UserDto;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;



    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;

    }

    @Override
    public Boolean create(User user ){
        userRepository.save(user);
        return null;
    }

    @Override
    public User findById(String id )
    {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteById(String id ){
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public Boolean update(String userId, User user) {
        return null;
    }


    @Override
    public List<User> findusercreatedafter(Date startDate) {
        return userRepository.findBycreatedAtAfter (startDate) ;
    }


    @Override
    public String next() {
        return null;
    }

    @Override
    public List<User> findUsersLN(String queryText) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}