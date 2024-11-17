package com.debkanta.projects.NewsAggregatorAPI.service;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import com.debkanta.projects.NewsAggregatorAPI.entity.Preferences;
import com.debkanta.projects.NewsAggregatorAPI.model.NewsCategory;
import com.debkanta.projects.NewsAggregatorAPI.repository.AuthUserRepository;
import com.debkanta.projects.NewsAggregatorAPI.repository.PreferencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferencesService {
    @Autowired
    PreferencesRepository preferencesRepository;
    @Autowired
    AuthUserRepository authUserRepository;

    public List<NewsCategory> getPreferences(long userId) {
        AuthUser authUser = authUserRepository.findByUserId(userId);

        return preferencesRepository.findPreferencesByUser(authUser).getPreferences();
    }

    public boolean updatePreferences(long userId, List<NewsCategory> preferences) {
        AuthUser user = authUserRepository.findByUserId(userId);
        Preferences userPreferences = new Preferences(preferences, user);

        preferencesRepository.save(userPreferences);

        return true;
    }
}
