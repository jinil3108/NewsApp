package com.example.newsapp.data

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemNewsBinding
import com.example.newsapp.model.News
import com.example.newsapp.utils.Utils

class NewsAdapter(private val listener: NewsItemListener) : RecyclerView.Adapter<NewsViewHolder>() {

    private val items: MutableList<News> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(
            ItemNewsBinding.inflate(
                inflater,
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNewsList(updatedNewsList: List<News>) {
        items.clear()
        items.addAll(updatedNewsList)
        notifyDataSetChanged()
    }
}

class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(news: News, listener: NewsItemListener) {
        binding.root.setOnClickListener {
            listener.onItemClicked(news)
        }
        binding.titleNews.text = news.title
        binding.descriptionNews.text = news.description
        binding.sourceNews.text = news.source.name
        binding.publishedNews.text = Utils.changeDateFormat(news.publishedAt)
        Glide.with(itemView.context).load(news.urlToImage).into(binding.imageNews)
    }
}

interface NewsItemListener {
    fun onItemClicked(item: News)
}