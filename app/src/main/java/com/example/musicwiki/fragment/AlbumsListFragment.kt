package com.example.musicwiki.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.adapter.AlbumsListAdapter
import com.example.musicwiki.databinding.FragmentAlbumsListBinding
import com.example.musicwiki.viewmodelfactory.AlbumsListFragmentViewModelFactory
import com.example.musicwiki.viewmodels.AlbumsListFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel


class AlbumsListFragment : Fragment() {

    lateinit var binding: FragmentAlbumsListBinding
    private lateinit var adapter: AlbumsListAdapter
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsListBinding.inflate(inflater, container, false)

        sharedViewModel.genres.observe(viewLifecycleOwner) {
            val viewModel = ViewModelProvider(
                this, AlbumsListFragmentViewModelFactory(it)
            )[AlbumsListFragmentViewModel::class.java]

            viewModel.artists.observe(viewLifecycleOwner) {
                if (it != null) adapter.setContentList(it.albums.album.toMutableList())
            }
        }

        adapter = AlbumsListAdapter()

        binding.recyclerView.adapter = this.adapter

        return binding.root
    }
}