package com.example.springboot.data;

import com.example.springboot.controller.auth.RoleEnum;
import com.example.springboot.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Document(collation = "task")

public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private String lastName;
    private LocalDate createdAt;
    private String passwordHash;
    private List<RoleEnum> roles;

    public User(){}
    public User(String id,UserDto userDto) {
        LocalDate localDate = LocalDate.now();
        this.id=id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getEmail();
        this.createdAt = localDate;
        this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());

    }
    public void update(UserDto user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.lastName = user.getLastName();
        if (user.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roles) {
        this.roles = roles;
    }

    /*public User( String id, UserDto userDto, String createdAt) {
        this.id=id;
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.lastName = userDto.getEmail();
        this.createdAt = createdAt;
    }*/


    public String getId() {
        return String.valueOf(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", passwordHash='" + passwordHash + '\'' +
                ", roles=" + roles +
                '}';
    }
}
