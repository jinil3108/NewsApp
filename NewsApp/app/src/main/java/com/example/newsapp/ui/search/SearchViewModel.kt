package com.example.newsapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.News
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.utils.ApiClient
import com.example.newsapp.utils.Utils
import retrofit2.Call
import retrofit2.Callback

class SearchViewModel(): ViewModel() {

    var newsList = MutableLiveData<List<News>>()
    var isError = MutableLiveData(false)

    fun searchNews(query: String){
        val call = ApiClient.getInstance().searchNews(query)
        call.enqueue(object: Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: retrofit2.Response<NewsResponse>) {
                if(response.body()?.status.equals("ok")) {
                    val articleList : List<News> = response.body()!!.news
                    if(articleList.isNotEmpty()) {
                        newsList.value = articleList
                        isError.value = false
                    }
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                isError.value = true
            }
        })
    }
}