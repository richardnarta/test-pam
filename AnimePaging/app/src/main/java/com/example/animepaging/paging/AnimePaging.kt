package com.example.animepaging.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animepaging.api.ApiService
import com.example.animepaging.models.Data
import com.example.animepaging.models.Node

class AnimePaging(private val apiService: ApiService): PagingSource<Int, Node>() {
    override fun getRefreshKey(state: PagingState<Int, Node>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Node> {
        return try {
            val currentOffset = params.key ?: 0
            val response = apiService.getAnime("2023", "summer", currentOffset, "anime_num_list_users")
            Log.d("response", "$response")
            val dataAnime = response.body()?.data as List<Data>
            val responseData = mutableListOf<Node>()
            for(data in dataAnime){
                data.node?.let {responseData.add(it)}
                Log.d("response", "$data")
            }

            Log.d("data", "$responseData")

            LoadResult.Page(
                data=responseData,
                prevKey = if(currentOffset == 0) null else -10,
                nextKey = currentOffset.plus(10)
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }

}