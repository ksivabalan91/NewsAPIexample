package com.iss.nus.newsexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iss.nus.newsexample.models.News;
import com.iss.nus.newsexample.services.NewsService;

@Controller
@RequestMapping(path={"/","/index"})

public class NewsController {

    @Autowired
    private NewsService newsSvc;

    @GetMapping(path="/headlines")
    public String gethead(@RequestParam MultiValueMap<String,String> form, Model model ){

        List<News> newsList = newsSvc.getHeadlines(form.getFirst("country"),form.getFirst("category"));

        model.addAttribute("news", newsList);
        
        return "headlines";
    }
    
}
