package com.example.springboot.controller;

import com.example.springboot.data.User;
import com.example.springboot.dto.UserDto;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById(@PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }


    @PostMapping
    public ResponseEntity<Boolean> create( @RequestBody UserDto userDto ) {
        User user = new User(userService.next(), userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<Boolean> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        User user = new User(id,userDto,userService.findById(id).getCreatedAt());
        return ResponseEntity.status(HttpStatus.OK).body(userService.update(id,user));
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteById(id));
    }
}