package com.example.newsapp.ui.search

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.NewsDetailActivity
import com.example.newsapp.data.NewsAdapter
import com.example.newsapp.data.NewsItemListener
import com.example.newsapp.databinding.FragmentSearchBinding
import com.example.newsapp.model.News

class SearchFragment : Fragment() , NewsItemListener{

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAdapter: NewsAdapter
    private val searchViewModel: SearchViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        initRecyclerView()
        initSearchView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewModel.newsList.observe(viewLifecycleOwner) { list ->
            list?.let {
                mAdapter.updateNewsList(it)
            }
        }
        searchViewModel.isError.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                // Handle error
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initRecyclerView(){
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = NewsAdapter(this)
        binding.recyclerView.adapter = mAdapter
    }

    private fun initSearchView(){
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query?.isNotEmpty() == true) {
                    searchViewModel.searchNews(query)
                }
                return true
            }

            @RequiresApi(Build.VERSION_CODES.O)
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
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