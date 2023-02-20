package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentAlbumDetailBinding
import com.example.musicwiki.viewmodelfactory.AlbumDetailFragmentViewModelFactory
import com.example.musicwiki.viewmodelfactory.GenresDetailFragmentViewModelFactory
import com.example.musicwiki.viewmodels.AlbumDetailFragmentViewModel
import com.example.musicwiki.viewmodels.GenresDetailFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel


class AlbumDetailFragment : Fragment() {

    lateinit var binding: FragmentAlbumDetailBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumDetailBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProvider(
            this, AlbumDetailFragmentViewModelFactory(sharedViewModel.artistName.value.toString(), sharedViewModel.albumName.value.toString())
        )[AlbumDetailFragmentViewModel::class.java]
        binding.model = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}