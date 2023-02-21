package com.example.musicwiki.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapter.MainRecyclerViewAdapter
import com.example.musicwiki.databinding.FragmentAlbumDetailBinding
import com.example.musicwiki.viewmodelfactory.AlbumDetailFragmentViewModelFactory
import com.example.musicwiki.viewmodels.AlbumDetailFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel


class AlbumDetailFragment : Fragment() {

    lateinit var binding: FragmentAlbumDetailBinding
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var adapterGenres: MainRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlbumDetailBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(
            this,
            AlbumDetailFragmentViewModelFactory(
                sharedViewModel.artistName.value.toString(),
                sharedViewModel.albumName.value.toString(),
                sharedViewModel.imageLink.value.toString()
            )
        )[AlbumDetailFragmentViewModel::class.java]
        binding.model = viewModel
        binding.lifecycleOwner = this
        adapterGenres = MainRecyclerViewAdapter(sharedViewModel)

        viewModel.genres.observe(viewLifecycleOwner) {
            if (it != null) {
                adapterGenres.setContentList(it.toptags.tag.toMutableList())
            }
        }
        sharedViewModel.transition.observe(viewLifecycleOwner){
            if (it) {
                findNavController().navigate(R.id.action_albumDetailFragment_to_genresDetailFragment)
            }
        }

        binding.recyclerViewGenres.adapter = this.adapterGenres
        binding.recyclerViewGenres.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

}