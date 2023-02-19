package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.R
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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArtistDetailBinding.inflate(inflater, container, false)
        val artistName = sharedViewModel.artistName.value.toString()
        val viewModel = ViewModelProvider(this, ArtistDetailFragmentViewModelFactory(artistName))[ArtistDetailFragmentViewModel::class.java]

        binding.model = viewModel
        binding.lifecycleOwner = this


        return binding.root
    }

}