package com.debkanta.projects.NewsAggregatorAPI.service;

import com.debkanta.projects.NewsAggregatorAPI.model.NewsModel;

import java.util.List;

public class NewsService {
    public List<NewsModel> getNews(long userId) {
        return List.of(new NewsModel());
    }
}
