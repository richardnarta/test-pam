package com.example.animepaging.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.animepaging.api.ApiService
import com.example.animepaging.paging.AnimePaging
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val apiService: ApiService):ViewModel(){

    val listAnime = Pager(PagingConfig(pageSize = 1)){
        Log.d("vm", "hello")
        AnimePaging(apiService)
    }.flow.cachedIn(viewModelScope)
}