package com.jade.learnjwtbasic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {
    @RequestMapping("/home")
    public String home(){
        return "Bạn đã truy cập thành công - Test Jwt";
    }
}
