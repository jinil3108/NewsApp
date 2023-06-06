package com.example.newsapp.ui.trend

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.News
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.utils.ApiClient
import com.example.newsapp.utils.Utils
import retrofit2.Call
import retrofit2.Callback

@RequiresApi(Build.VERSION_CODES.O)
class TrendingViewModel : ViewModel() {

    var selectedCategory: String = "All"
    var selectedCountry: String = "in"
    var trendNews: MutableLiveData<List<News>> = MutableLiveData<List<News>>()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>(true)
    var isFailure: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    init {
        fetchTrendingNews()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun fetchTrendingNews() {
        val call = if (selectedCategory == "All") {
            ApiClient.getInstance().getLatestNewsByCountry(country = selectedCountry)
        } else {
            ApiClient.getInstance().getLatestNewsByCategoryAndCountry(
                category = selectedCategory,
                country = selectedCountry
            )
        }

        call.enqueue(object : Callback<NewsResponse> {
            override fun onResponse(
                call: Call<NewsResponse>,
                response: retrofit2.Response<NewsResponse>
            ) {
                if (response.body()?.status.equals("ok")) {
                    val articleList: List<News> = response.body()!!.news
                    if (articleList.isNotEmpty()) {
                        trendNews.value = articleList
                    }
                    isLoading.value = false
                    isFailure.value = false
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                isLoading.value = false
                isFailure.value = true
            }
        })
    }

}