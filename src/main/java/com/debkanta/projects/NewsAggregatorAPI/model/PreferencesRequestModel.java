package com.debkanta.projects.NewsAggregatorAPI.model;

import lombok.Data;

import java.util.List;

@Data
public class PreferencesRequestModel {
    private long userId;
    private List<NewsCategory> preferences;
}
