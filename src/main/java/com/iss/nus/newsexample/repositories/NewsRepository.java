package com.iss.nus.newsexample.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iss.nus.newsexample.services.NewsService;

@Repository
public class NewsRepository {

    @Autowired
    private NewsService newsSvc;

    
    
}
