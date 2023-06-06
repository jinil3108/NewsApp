package com.example.newsapp.db

import androidx.lifecycle.LiveData
import com.example.newsapp.model.News

class NewsRepository(newsDao: NewsDao) {
    val savedNews: LiveData<List<News>> = newsDao.getAllNews()
}