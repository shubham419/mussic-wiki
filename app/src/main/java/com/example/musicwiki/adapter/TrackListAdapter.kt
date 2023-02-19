package com.example.musicwiki.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.TrackListItemBinding
import com.example.musicwiki.models.track.Track

class TrackListAdapter : RecyclerView.Adapter<TrackListAdapter.MyViewHolder>() {
    var list = mutableListOf<Track>()

    fun setContentList(list: MutableList<Track>) {
        this.list = list
        notifyDataSetChanged()
    }


    class MyViewHolder(val viewDataBinding: TrackListItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder = MyViewHolder(
        TrackListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.track = this.list[position]

    }

}
