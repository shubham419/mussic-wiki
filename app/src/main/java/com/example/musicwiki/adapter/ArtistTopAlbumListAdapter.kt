package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistTopAlbumListItemBinding
import com.example.musicwiki.databinding.ArtistTopTrackListItemBinding
import com.example.musicwiki.models.artisttopalbum.Album

class ArtistTopAlbumListAdapter : RecyclerView.Adapter<ArtistTopAlbumListAdapter.MyViewHolder>() {

    var list = mutableListOf<Album>()

    fun setContentList(list: MutableList<Album>) {
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder (val viewDataBinding: ArtistTopAlbumListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder  =
        ArtistTopAlbumListAdapter.MyViewHolder(
            ArtistTopAlbumListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount():  Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.album = this.list[position]

    }
}