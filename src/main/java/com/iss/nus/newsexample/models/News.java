package com.iss.nus.newsexample.models;

public class News {

    private String source;
    private String title;
    private String link;
    
    public News() {}
    public News(String source, String title, String link) {
        this.source = source;
        this.title = title;
        this.link = link;
    }

    public String getSource() {return source;}
    public void setSource(String source) {this.source = source;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getLink() {return link;}
    public void setLink(String link) {this.link = link;}
    
    @Override
    public String toString() {
        return "News [source=" + source + ", title=" + title + ", link=" + link + "]";
    } 
    
    
}
