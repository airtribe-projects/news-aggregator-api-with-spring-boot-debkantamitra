package com.debkanta.projects.NewsAggregatorAPI.repository;

import com.debkanta.projects.NewsAggregatorAPI.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
