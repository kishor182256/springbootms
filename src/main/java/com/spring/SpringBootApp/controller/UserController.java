package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.dto.UserRequest;
import com.spring.SpringBootApp.dto.UserResponse;
import com.spring.SpringBootApp.model.User;
import com.spring.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Long userId = 1L;

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), org.springframework.http.HttpStatus.OK);
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> addAllUsers(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
        return ResponseEntity.ok("User added successfully");
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser) ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }


}
