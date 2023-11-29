package com.jade.learnjwtbasic.service.auth;

import com.jade.learnjwtbasic.dtos.SignupRequest;
import com.jade.learnjwtbasic.dtos.UserDTO;
import com.jade.learnjwtbasic.entity.User;
import com.jade.learnjwtbasic.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImlp implements AuthService{

    @Autowired
    private UserReponsitory userReponsitory;


    @Override
    public UserDTO createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setEmail(signupRequest.getEmail());
        user.setPhone(signupRequest.getPhone());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userReponsitory.save(user);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setUsername(createdUser.getUsername());
        userDTO.setPhone(createdUser.getPhone());
        return userDTO;
    }
}
