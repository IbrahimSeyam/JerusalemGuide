package com.example.jerusalem.response;

import com.example.jerusalem.model.Article;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private long totalResults;

    @SerializedName("articles")
    private List<Article> articles;


    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }


    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long value) {
        this.totalResults = value;
    }


    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> value) {
        this.articles = value;
    }


}
