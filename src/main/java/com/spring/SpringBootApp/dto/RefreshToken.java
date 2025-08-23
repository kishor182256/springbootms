package com.spring.SpringBootApp.dto;

import com.spring.SpringBootApp.model.User;
import jakarta.persistence.OneToOne;

import java.time.Instant;


public class RefreshToken {

    private  int id;
    private String refreshToken;

    @OneToOne
    private UserRequest userRequest;
    private Instant expiresAt;

}
