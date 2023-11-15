package com.example.animepaging

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animepaging.databinding.AnimeCardBinding
import com.example.animepaging.models.Node

class AnimeAdapter:PagingDataAdapter<Node, AnimeAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: AnimeCardBinding): RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffCallback = object: DiffUtil.ItemCallback<Node>(){
            override fun areItemsTheSame(oldItem: Node, newItem: Node): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Node, newItem: Node): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentAnime = getItem(position)

        Log.d("adapter", "$currentAnime")

        holder.binding.apply {
            tvTitle.text = currentAnime?.title
            tvId.text = currentAnime?.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        Log.d("adapter", "created")
        return MyViewHolder(AnimeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
}