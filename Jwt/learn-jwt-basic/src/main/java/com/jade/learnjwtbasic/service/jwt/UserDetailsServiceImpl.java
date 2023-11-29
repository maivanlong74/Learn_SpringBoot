package com.jade.learnjwtbasic.service.jwt;

import com.jade.learnjwtbasic.entity.User;
import com.jade.learnjwtbasic.reponsitory.UserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserReponsitory userReponsitory;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userReponsitory.findFirstByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Không có tài khoản",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
