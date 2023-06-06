package com.example.newsapp.ui.saved

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.db.NewsRepository

class SavedViewModelFactory( private val newsRepository: NewsRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SavedViewModel::class.java)) {
            return SavedViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}