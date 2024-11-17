package com.debkanta.projects.NewsAggregatorAPI.repository;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    AuthUser findByEmail(String userName);
    AuthUser findByUserId(long id);
}
