package com.iss.nus.newsexample.services;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.iss.nus.newsexample.models.News;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class NewsService {

    @Value(value = "${api.key}")
    private String API_KEY;

    public List<News> getHeadlines(String country, String category){
        
        // https://newsapi.org/v2/top-headlines?country=us&apiKey=74b48a1deb29451a80c6fe83660cba0d
        String URL = UriComponentsBuilder
            .fromUriString("https://newsapi.org/v2/top-headlines")
            .queryParam("category", category)
            .queryParam("country", country)
            .toUriString();

        RequestEntity<Void> req = RequestEntity
            .get(URL)
            .header("X-Api-Key", API_KEY)
            .accept(MediaType.APPLICATION_JSON)
            .build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;

        String payload;
        int statuscode;

        try{
            resp = template.exchange(req, String.class);
            payload = resp.getBody();
            statuscode=resp.getStatusCode().value();
            
        }catch(HttpClientErrorException ex){
            payload = ex.getResponseBodyAsString();
            statuscode = ex.getStatusCode().value();
        }

        JsonReader jsonReader = Json.createReader(new StringReader(payload));
        JsonObject jsonObject = jsonReader.readObject();
        JsonArray jsonArr = jsonObject.getJsonArray("articles");

        List<News> newsList = new LinkedList<>();

        for(int i=0;i<jsonArr.size();i++){
            News news = new News();
            String title = jsonArr.getJsonObject(i).getString("title");
            String link = jsonArr.getJsonObject(i).getString("url");
            String source = jsonArr.getJsonObject(i).getJsonObject("source").getString("name");

            news.setTitle(title);
            news.setLink(link);
            news.setSource(source);
            newsList.add(news);
        }

        System.out.println(newsList.toString());       

        return newsList;
    }
    
}
