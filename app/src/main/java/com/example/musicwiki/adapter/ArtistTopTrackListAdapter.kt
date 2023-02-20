package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ArtistTopTrackListItemBinding
import com.example.musicwiki.models.artisttoptrack.Track

class ArtistTopTrackListAdapter:
RecyclerView.Adapter<ArtistTopTrackListAdapter.MyViewHolder>() {


    var list = mutableListOf<Track>()

    fun setContentList(list: MutableList<Track>) {
        this.list = list
        notifyDataSetChanged()
    }


    class MyViewHolder(val viewDataBinding: ArtistTopTrackListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        ArtistTopTrackListAdapter.MyViewHolder(
            ArtistTopTrackListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.track = this.list[position]
    }
}