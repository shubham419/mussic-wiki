package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.AlbumsListItemBinding
import com.example.musicwiki.databinding.ArtistsListItemBinding
import com.example.musicwiki.models.album.Album
import com.example.musicwiki.models.artists.Artist

class AlbumsListAdapter : RecyclerView.Adapter<AlbumsListAdapter.MyViewHolder>() {
    var list = mutableListOf<Album>()

    fun setContentList(list: MutableList<Album>) {
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewDataBinding: AlbumsListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): AlbumsListAdapter.MyViewHolder = MyViewHolder(
        AlbumsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )


    override fun onBindViewHolder(holder: AlbumsListAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.album = this.list[position]
    }

    override fun getItemCount(): Int = list.size
}