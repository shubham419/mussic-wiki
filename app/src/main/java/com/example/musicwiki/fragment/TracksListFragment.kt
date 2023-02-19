package com.example.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.R
import com.example.musicwiki.adapter.ArtistsListAdapter
import com.example.musicwiki.adapter.TrackListAdapter
import com.example.musicwiki.databinding.FragmentArtistsListBinding
import com.example.musicwiki.databinding.FragmentTracksListBinding
import com.example.musicwiki.viewmodelfactory.ArtistsListFragmentViewModelFactory
import com.example.musicwiki.viewmodelfactory.TracksListFragmentViewModelFactory
import com.example.musicwiki.viewmodels.ArtistsListFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel
import com.example.musicwiki.viewmodels.TracksListFragmentViewModel


class TracksListFragment : Fragment() {

    lateinit var binding: FragmentTracksListBinding
    private lateinit var adapter: TrackListAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentTracksListBinding.inflate(inflater, container, false)

        val tageName = sharedViewModel.genres.value.toString()
        val viewModel = ViewModelProvider(this, TracksListFragmentViewModelFactory(tageName))[TracksListFragmentViewModel::class.java]

        adapter = TrackListAdapter()
        viewModel.tracks.observe(viewLifecycleOwner){
            if(it != null) adapter.setContentList(it.tracks.track.toMutableList())
        }

        binding.recyclerView.adapter = this.adapter

        return binding.root
    }

}