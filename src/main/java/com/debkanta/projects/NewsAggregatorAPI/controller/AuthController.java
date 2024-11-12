package com.debkanta.projects.NewsAggregatorAPI.controller;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.model.AuthUserModel;
import com.debkanta.projects.NewsAggregatorAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthUser register(@RequestBody AuthUserModel user) {
        return authService.register(user);
    }

    @GetMapping("/user")
    public String getUser() {
        return "Debkanta";
    }
}
