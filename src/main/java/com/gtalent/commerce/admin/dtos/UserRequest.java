package com.gtalent.commerce.admin.dtos;

import lombok.Data;

import java.time.LocalDate;


    @Data
    public class UserRequest {
        private String firstName;
        private String lastName;
        private String email;
        private LocalDate birthday;
        private String country;
        private String address;
        private String city;
        private String zipcode;
        private String password;
        private String role;
        private boolean hasNewsletter;
    }


