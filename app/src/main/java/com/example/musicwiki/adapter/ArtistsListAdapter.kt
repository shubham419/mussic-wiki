package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistsListItemBinding
import com.example.musicwiki.models.artists.Artist
import com.example.musicwiki.viewmodels.SharedViewModel

class ArtistsListAdapter(val model: SharedViewModel) :
    RecyclerView.Adapter<ArtistsListAdapter.MyViewHolder>() {

    var list = mutableListOf<Artist>()

    fun setContentList(list: MutableList<Artist>) {
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewDataBinding: ArtistsListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ArtistsListAdapter.MyViewHolder = MyViewHolder(
        ArtistsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ArtistsListAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.artist = this.list[position]
        holder.viewDataBinding.model = model
    }

    override fun getItemCount(): Int = list.size
}