package com.example.newsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityNewsDetailBinding
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.model.News
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsDetailActivity : AppCompatActivity(){

    private lateinit var binding: ActivityNewsDetailBinding
    private var news: News? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        news = intent.getSerializableExtra("News") as News

        binding = ActivityNewsDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        news?.url?.let { newsUrl ->
            binding.webView.apply {
                settings.javaScriptEnabled = true
                loadUrl(newsUrl)
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_news_detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.navigation_save -> {
                saveNews()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun saveNews() {
        news?.let { news ->
            GlobalScope.launch(Dispatchers.IO) {
                NewsDatabase.getInstance(this@NewsDetailActivity).getNewsDao().insertNews(news)
                Handler(Looper.getMainLooper()).post{
                    Toast.makeText(this@NewsDetailActivity, "News Saved", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

}

