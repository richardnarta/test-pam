package com.example.animepaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animepaging.databinding.ActivityMainBinding
import com.example.animepaging.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var animeAdapter:AnimeAdapter
    private val viewModel:MainViewModel by viewModels()

//    private lateinit var dummyAdapter: DummyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRv()

        loadData()
    }

    private fun loadData(){
        lifecycleScope.launch {
            Log.d("coroutine", "${viewModel.listAnime}")
            viewModel.listAnime.collect{paging->
                Log.d("data", "$paging")
                animeAdapter.submitData(paging)
            }
        }
    }

    private fun createRv(){
        animeAdapter = AnimeAdapter()
        Log.d("adapter", "$animeAdapter")
//        dummyAdapter = DummyAdapter(mutableListOf())
//        dummyAdapter.addUser(Node(123, "Naruto"))
        binding.recycleView.apply {

            layoutManager = LinearLayoutManager(context)
            adapter = animeAdapter

//            adapter = dummyAdapter

            setHasFixedSize(true)
        }
    }
}