package com.debkanta.projects.NewsAggregatorAPI.controller;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.model.AuthUserModel;
import com.debkanta.projects.NewsAggregatorAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello_world")
public class HelloWorldController {

    @Autowired
    private AuthService authService;

    @GetMapping
    public String getHelloWorld() {
        return "Hello, world!";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Debkanta";
    }

    @PostMapping("/register")
    public AuthUser register(@RequestBody AuthUserModel user) {
        return authService.register(user);
    }
}
