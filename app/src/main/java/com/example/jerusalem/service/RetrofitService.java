package com.example.jerusalem.service;

import com.example.jerusalem.model.Article;
import com.example.jerusalem.response.ArticleResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
//    @GET("everything")
//    Call<ResponseBody> getArticle();

    @GET("everything")
    Call<ArticleResponse> getArticle(
            @Query("q") String q,
            @Query("from") String from,
            @Query("to") String to,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
}
