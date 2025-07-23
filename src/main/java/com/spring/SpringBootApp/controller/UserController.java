package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Long userId = 1L;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add-user")
    public void addAllUsers(@RequestBody User newUsers){
        userService.addUser(newUsers);
    }

    @PutMapping("/update-user/{id}")
    public boolean updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }


}
