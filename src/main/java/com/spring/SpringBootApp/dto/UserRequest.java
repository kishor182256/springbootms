package com.spring.SpringBootApp.dto;


import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String name;
    private String email;
    private String role = "USER";
    private String password;

    private AddressDto address;


}
