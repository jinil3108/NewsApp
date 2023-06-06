package com.example.newsapp.ui.saved;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/newsapp/ui/saved/SavedViewModel;", "Landroidx/lifecycle/ViewModel;", "newsRepository", "Lcom/example/newsapp/db/NewsRepository;", "(Lcom/example/newsapp/db/NewsRepository;)V", "savedNews", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/newsapp/model/News;", "getSavedNews", "()Landroidx/lifecycle/LiveData;", "setSavedNews", "(Landroidx/lifecycle/LiveData;)V", "app_debug"})
public final class SavedViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.model.News>> savedNews;
    
    public SavedViewModel(@org.jetbrains.annotations.NotNull()
    com.example.newsapp.db.NewsRepository newsRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.model.News>> getSavedNews() {
        return null;
    }
    
    public final void setSavedNews(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.example.newsapp.model.News>> p0) {
    }
}