package com.debkanta.projects.NewsAggregatorAPI.service;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.model.AuthUserModel;
import com.debkanta.projects.NewsAggregatorAPI.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUser register(AuthUserModel user) {
        System.out.println("AuthUser Service");
        AuthUser newUser = new AuthUser();

        newUser.setUserName(user.getUserName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEnabled(false);
        newUser.setRole("USER");

        return authUserRepository.save(newUser);
    }
}
