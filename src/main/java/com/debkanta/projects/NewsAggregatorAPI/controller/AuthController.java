package com.debkanta.projects.NewsAggregatorAPI.controller;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.entity.VerificationToken;
import com.debkanta.projects.NewsAggregatorAPI.model.AuthUserModel;
import com.debkanta.projects.NewsAggregatorAPI.model.RegistrationResponseModel;
import com.debkanta.projects.NewsAggregatorAPI.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Value("${application-url}")
    private String applicationUrl;

    @PostMapping("/register")
    public RegistrationResponseModel register(@Valid @RequestBody AuthUserModel user) {
        AuthUser storedUser = authService.register(user);

        String token = UUID.randomUUID().toString();
        String url = applicationUrl + "api/verifyRegistration?token=" + token;

        VerificationToken verificationToken = authService.createVerificationToken(token, storedUser);

        return new RegistrationResponseModel(storedUser, url);
    }

    @PostMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        boolean isUserEnabled = authService.verifyRegistration(token);

        if(isUserEnabled) {
            return "User has been enabled successfully!";
        } else {
            return "Failed to enable user";
        }
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String email, @RequestParam String password) {
        return authService.signin(email, password);
    }
}
