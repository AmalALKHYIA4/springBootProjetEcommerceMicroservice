package com.ecom.app.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String phone ;
    private AdressDto adressDto ;
}
