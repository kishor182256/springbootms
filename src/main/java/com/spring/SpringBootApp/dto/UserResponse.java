package com.spring.SpringBootApp.dto;


import lombok.Data;

@Data
public class UserResponse {

    private String id;
    private String name;
    private String email;
    private String role;

    private AddressDto address;



}
