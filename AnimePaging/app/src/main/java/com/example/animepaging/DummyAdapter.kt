package com.example.animepaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animepaging.databinding.AnimeCardBinding
import com.example.animepaging.models.Node

class DummyAdapter (private var users:MutableList<Node>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun addUser(new:Node){
        users.add(new)
        notifyItemInserted(users.lastIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListViewHolder(AnimeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ListViewHolder){
            val user = users[position]

            holder.tvTitle.text = user.title
            holder.tvId.text = user.id.toString()
        }
    }

    inner class ListViewHolder(binding: AnimeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvTitle = binding.tvTitle
        val tvId = binding.tvId
    }

}