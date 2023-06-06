package com.example.newsapp.ui.saved

import androidx.lifecycle.*
import com.example.newsapp.db.NewsRepository
import com.example.newsapp.model.News


class SavedViewModel(newsRepository: NewsRepository) : ViewModel() {

    var savedNews: LiveData<List<News>>

    init {
        savedNews = newsRepository.savedNews
    }
}