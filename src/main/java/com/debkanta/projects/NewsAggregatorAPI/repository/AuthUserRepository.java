package com.debkanta.projects.NewsAggregatorAPI.repository;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
}
