package com.example.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.musicwiki.R
import com.example.musicwiki.adapter.ArtistsListAdapter
import com.example.musicwiki.adapter.MainRecyclerViewAdapter
import com.example.musicwiki.databinding.FragmentArtistsListBinding
import com.example.musicwiki.viewmodelfactory.ArtistsListFragmentViewModelFactory
import com.example.musicwiki.viewmodels.ArtistsListFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel


class ArtistsListFragment : Fragment() {

    lateinit var binding: FragmentArtistsListBinding
    private lateinit var adapter: ArtistsListAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArtistsListBinding.inflate(inflater, container, false)
        val tageName = sharedViewModel.genres.value.toString()
        val viewModel = ViewModelProvider(this, ArtistsListFragmentViewModelFactory(tageName))[ArtistsListFragmentViewModel::class.java]

        adapter = ArtistsListAdapter(sharedViewModel)
        viewModel.artists.observe(viewLifecycleOwner){
            if(it != null) adapter.setContentList(it.topartists.artist.toMutableList())
        }


        binding.recyclerView.adapter = this.adapter

        return binding.root
    }

}