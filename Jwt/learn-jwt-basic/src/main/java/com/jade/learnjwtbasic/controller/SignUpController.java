package com.jade.learnjwtbasic.controller;

import com.jade.learnjwtbasic.dtos.SignupRequest;
import com.jade.learnjwtbasic.dtos.UserDTO;
import com.jade.learnjwtbasic.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody SignupRequest signupRequest){
        UserDTO createdUser = authService.createUser(signupRequest);
        if (createdUser == null)
            return new ResponseEntity<>("Chưa tạo được tài khoản", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
