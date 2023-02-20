package com.example.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapter.ArtistTopAlbumListAdapter
import com.example.musicwiki.adapter.ArtistTopTrackListAdapter
import com.example.musicwiki.adapter.ArtistsListAdapter
import com.example.musicwiki.databinding.FragmentArtistDetailBinding
import com.example.musicwiki.databinding.FragmentArtistsListBinding
import com.example.musicwiki.viewmodelfactory.ArtistDetailFragmentViewModelFactory
import com.example.musicwiki.viewmodelfactory.ArtistsListFragmentViewModelFactory
import com.example.musicwiki.viewmodels.ArtistDetailFragmentViewModel
import com.example.musicwiki.viewmodels.ArtistsListFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel

class ArtistDetailFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    lateinit var binding: FragmentArtistDetailBinding
    private lateinit var adapter: ArtistTopTrackListAdapter
    private lateinit var adapterAlbum: ArtistTopAlbumListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtistDetailBinding.inflate(inflater, container, false)
        val artistName = sharedViewModel.artistName.value.toString()
        val viewModel = ViewModelProvider(this, ArtistDetailFragmentViewModelFactory(artistName))[ArtistDetailFragmentViewModel::class.java]

        adapter = ArtistTopTrackListAdapter()
        adapterAlbum = ArtistTopAlbumListAdapter()
        viewModel.tracks.observe(viewLifecycleOwner){
//            Log.d("abcde", it.toString())
            if(it != null) adapter.setContentList(it.toptracks.track.toMutableList())
        }

        viewModel.album.observe(viewLifecycleOwner){
            if(it != null) adapterAlbum.setContentList(it.topalbums.album.toMutableList())
        }

        binding.model = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = this.adapter
        binding.recyclerViewAlbum.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewAlbum.adapter = this.adapterAlbum
        return binding.root
    }

}