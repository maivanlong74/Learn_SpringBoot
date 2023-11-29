package com.jade.learnjwtbasic.service.auth;

import com.jade.learnjwtbasic.dtos.SignupRequest;
import com.jade.learnjwtbasic.dtos.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupRequest signupRequest);
}
