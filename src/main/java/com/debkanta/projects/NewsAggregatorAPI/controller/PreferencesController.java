package com.debkanta.projects.NewsAggregatorAPI.controller;

import com.debkanta.projects.NewsAggregatorAPI.model.NewsCategory;
import com.debkanta.projects.NewsAggregatorAPI.model.PreferencesRequestModel;
import com.debkanta.projects.NewsAggregatorAPI.service.PreferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferences")
public class PreferencesController {
    @Autowired
    PreferencesService preferencesService;

    @GetMapping
    public List<NewsCategory> getPreferences(@RequestParam long userId) {
        return preferencesService.getPreferences(userId);
    }

    @PutMapping
    public String updatePreferences(@RequestBody PreferencesRequestModel preferencesRequestModel) {
        boolean hasUdatedPreferences = preferencesService.updatePreferences(
                preferencesRequestModel.getUserId(),
                preferencesRequestModel.getPreferences());

        if (hasUdatedPreferences) {
            return "Updated Preferences Successfully!";
        }

        return "Failed to update preferences";
    }
}
