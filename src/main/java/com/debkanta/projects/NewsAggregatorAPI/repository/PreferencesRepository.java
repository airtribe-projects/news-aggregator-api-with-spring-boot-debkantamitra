package com.debkanta.projects.NewsAggregatorAPI.repository;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.entity.Preferences;
import com.debkanta.projects.NewsAggregatorAPI.model.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferencesRepository extends JpaRepository<Preferences, Long> {
    Preferences findPreferencesByUser(AuthUser user);
}
