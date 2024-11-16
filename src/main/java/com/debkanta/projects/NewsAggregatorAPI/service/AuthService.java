package com.debkanta.projects.NewsAggregatorAPI.service;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.entity.VerificationToken;
import com.debkanta.projects.NewsAggregatorAPI.model.AuthUserModel;
import com.debkanta.projects.NewsAggregatorAPI.repository.AuthUserRepository;
import com.debkanta.projects.NewsAggregatorAPI.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

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

    public VerificationToken createVerificationToken(String token, AuthUser storedUser) {
        VerificationToken verificationToken = new VerificationToken(token, storedUser);

        return verificationTokenRepository.save(verificationToken);
    }

    public boolean verifyRegistration(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        boolean hasTokenExpired = verificationToken.getExpirationDate().before(new Date());

        if(hasTokenExpired) {
            return false;
        }

        verificationToken.getUser().setEnabled(true);

        AuthUser user = authUserRepository.save(verificationToken.getUser());
        verificationTokenRepository.delete(verificationToken);

        return user.isEnabled();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findByEmail(username);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(user.getEmail(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
