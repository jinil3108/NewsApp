package com.example.newsapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\'J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/newsapp/utils/APIInterface;", "", "getLatestNewsByCategoryAndCountry", "Lretrofit2/Call;", "Lcom/example/newsapp/model/NewsResponse;", "category", "", "country", "apiKey", "getLatestNewsByCountry", "searchNews", "query", "app_debug"})
public abstract interface APIInterface {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "top-headlines")
    public abstract retrofit2.Call<com.example.newsapp.model.NewsResponse> getLatestNewsByCountry(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "country")
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "top-headlines")
    public abstract retrofit2.Call<com.example.newsapp.model.NewsResponse> getLatestNewsByCategoryAndCountry(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "category")
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "country")
    java.lang.String country, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "everything")
    public abstract retrofit2.Call<com.example.newsapp.model.NewsResponse> searchNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey);
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 3)
    public final class DefaultImpls {
    }
}