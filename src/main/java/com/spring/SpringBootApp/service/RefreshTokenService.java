package com.spring.SpringBootApp.service;


import com.spring.SpringBootApp.dto.RefreshToken;
import org.springframework.stereotype.Service;

@Service
public interface RefreshTokenService {

    RefreshToken createRefreshToken(String userName);


    RefreshToken findByRefreshToken(String userName);


}
