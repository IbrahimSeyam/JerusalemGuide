package com.example.jerusalem.model;

import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("source")
    private Source source;

    @SerializedName("author")
    private String author;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("url")
    private String url;

    @SerializedName("urlToImage")
    private String urlToImage;

    @SerializedName("publishedAt")
    private String publishedAt;

    @SerializedName("content")
    private String content;


    public Source getSource() {
        return source;
    }

    public void setSource(Source value) {
        this.source = value;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }


    public String getURLToImage() {
        return urlToImage;
    }

    public void setURLToImage(String value) {
        this.urlToImage = value;
    }


    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String value) {
        this.publishedAt = value;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }

    @Override
    public String toString() {
        return "Article{" +
                "source=" + source +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
