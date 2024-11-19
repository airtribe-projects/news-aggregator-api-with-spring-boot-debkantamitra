//package com.debkanta.projects.NewsAggregatorAPI.controller;
//
//import com.debkanta.projects.NewsAggregatorAPI.model.NewsModel;
//import com.debkanta.projects.NewsAggregatorAPI.service.NewsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/news")
//public class NewsController {
//    @Autowired
//    NewsService newsService;
//
//    @GetMapping
//    public List<NewsModel> getNews(long userId) {
//        return newsService.getNews(userId);
//    }
//}
