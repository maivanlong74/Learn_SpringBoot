package com.jade.learnjwtbasic.dtos;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String email;
    private String phone;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
