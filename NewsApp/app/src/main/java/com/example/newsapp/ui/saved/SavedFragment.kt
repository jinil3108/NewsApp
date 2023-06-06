package com.example.newsapp.ui.saved

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.NewsDetailActivity
import com.example.newsapp.data.NewsAdapter
import com.example.newsapp.data.NewsItemListener
import com.example.newsapp.databinding.FragmentSavedBinding
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.db.NewsRepository
import com.example.newsapp.model.News

class SavedFragment : Fragment(), NewsItemListener {

    private var _binding: FragmentSavedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NewsAdapter
    private val savedViewModel by viewModels<SavedViewModel> {
        SavedViewModelFactory(
            NewsRepository(
                NewsDatabase.getInstance(requireActivity().applicationContext).getNewsDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSavedBinding.inflate(inflater, container, false)

        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NewsAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedViewModel.savedNews.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                adapter.updateNewsList(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(item: News) {
        val intent = Intent(context, NewsDetailActivity::class.java)
        intent.putExtra("News", item)
        startActivity(intent)
    }

}