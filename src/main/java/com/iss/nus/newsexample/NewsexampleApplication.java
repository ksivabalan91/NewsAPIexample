package com.iss.nus.newsexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iss.nus.newsexample.services.NewsService;

@SpringBootApplication
public class NewsexampleApplication implements CommandLineRunner{


	@Autowired
	private NewsService newsSvc;
	public static void main(String[] args) {
		SpringApplication.run(NewsexampleApplication.class, args);
	}

	@Override
	public void run(String...args){
		// newsSvc.getHeadlines("US", "technology");
		
	}

}
