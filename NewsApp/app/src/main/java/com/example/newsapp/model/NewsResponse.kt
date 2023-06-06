package com.example.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val status: String,
    @SerializedName("articles") val news: List<News>
)
