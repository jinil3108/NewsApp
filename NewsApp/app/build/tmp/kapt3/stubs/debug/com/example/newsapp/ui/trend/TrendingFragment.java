package com.example.newsapp.ui.trend;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006#"}, d2 = {"Lcom/example/newsapp/ui/trend/TrendingFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/example/newsapp/data/NewsItemListener;", "()V", "_binding", "Lcom/example/newsapp/databinding/FragmentTrendingBinding;", "binding", "getBinding", "()Lcom/example/newsapp/databinding/FragmentTrendingBinding;", "mAdapter", "Lcom/example/newsapp/data/NewsAdapter;", "trendingViewModel", "Lcom/example/newsapp/ui/trend/TrendingViewModel;", "getTrendingViewModel", "()Lcom/example/newsapp/ui/trend/TrendingViewModel;", "trendingViewModel$delegate", "Lkotlin/Lazy;", "initCategorySpinner", "", "initCountrySpinner", "initRecyclerView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onItemClicked", "item", "Lcom/example/newsapp/model/News;", "onViewCreated", "view", "app_debug"})
public final class TrendingFragment extends androidx.fragment.app.Fragment implements com.example.newsapp.data.NewsItemListener {
    private com.example.newsapp.databinding.FragmentTrendingBinding _binding;
    private com.example.newsapp.data.NewsAdapter mAdapter;
    private final kotlin.Lazy trendingViewModel$delegate = null;
    
    public TrendingFragment() {
        super();
    }
    
    private final com.example.newsapp.databinding.FragmentTrendingBinding getBinding() {
        return null;
    }
    
    private final com.example.newsapp.ui.trend.TrendingViewModel getTrendingViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private final void initRecyclerView() {
    }
    
    private final void initCategorySpinner() {
    }
    
    private final void initCountrySpinner() {
    }
    
    @java.lang.Override()
    public void onItemClicked(@org.jetbrains.annotations.NotNull()
    com.example.newsapp.model.News item) {
    }
}