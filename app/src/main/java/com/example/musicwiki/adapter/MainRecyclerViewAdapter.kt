package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.GenresListItemBinding
import com.example.musicwiki.models.genres.Tag
import com.example.musicwiki.viewmodels.SharedViewModel

class MainRecyclerViewAdapter(private val viewModel: SharedViewModel) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder>() {

    var list = mutableListOf<Tag>()

    fun setContentList(list: MutableList<Tag>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: GenresListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(
        GenresListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.tag = this.list[position]
        holder.viewDataBinding.sharedViewModel = viewModel
    }

    override fun getItemCount(): Int = this.list.size
}