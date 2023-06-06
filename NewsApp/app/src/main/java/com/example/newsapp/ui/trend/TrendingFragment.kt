package com.example.newsapp.ui.trend

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.NewsDetailActivity
import com.example.newsapp.data.NewsAdapter
import com.example.newsapp.data.NewsItemListener
import com.example.newsapp.databinding.FragmentTrendingBinding
import com.example.newsapp.model.News
import com.example.newsapp.utils.Utils

class TrendingFragment : Fragment(), NewsItemListener {

    private var _binding: FragmentTrendingBinding? = null
    private val binding get() = _binding!!
    private lateinit var mAdapter: NewsAdapter
    private val trendingViewModel: TrendingViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTrendingBinding.inflate(inflater, container, false)

        initRecyclerView()
        initCategorySpinner()
        initCountrySpinner()

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trendingViewModel.trendNews.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                mAdapter.updateNewsList(it)
            }
        })

        trendingViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

        trendingViewModel.isFailure.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                binding.progressBar.visibility = View.INVISIBLE
                Toast.makeText(context, "News Can't be Fetched", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = NewsAdapter(this)
        binding.recyclerView.adapter = mAdapter
    }

    private fun initCategorySpinner() {
        binding.categoryDropDwn.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                trendingViewModel.selectedCategory = parent.selectedItem.toString()
                trendingViewModel.fetchTrendingNews()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    private fun initCountrySpinner() {
        binding.countryDropDwn.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                trendingViewModel.selectedCountry =
                    Utils.countryMap[parent.selectedItem.toString()].toString()
                trendingViewModel.fetchTrendingNews()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

    override fun onItemClicked(item: News) {
        val intent = Intent(context, NewsDetailActivity::class.java)
        intent.putExtra("News", item)
        startActivity(intent)
    }
}