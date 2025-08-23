package com.spring.SpringBootApp.controller;

import com.spring.SpringBootApp.dto.UserRequest;
import com.spring.SpringBootApp.dto.UserResponse;
import com.spring.SpringBootApp.model.AuthRequest;
import com.spring.SpringBootApp.model.AuthResponse;
import com.spring.SpringBootApp.model.User;
import com.spring.SpringBootApp.repository.UserRepository;
import com.spring.SpringBootApp.security.JwtHelper;
import com.spring.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private Long userId = 1L;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsService userDetailsService;

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

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        try {
            // Authenticate using email & password
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()
                    )
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtHelper.generateToken(userDetails);

            return new AuthResponse(token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid email or password");
        }
    }



}




