package com.example.musicwiki.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.musicwiki.R
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.databinding.FragmentGenresDetailBinding
import com.example.musicwiki.databinding.GenresListItemBinding
import com.example.musicwiki.repository.GenresRepository
import com.example.musicwiki.viewmodelfactory.GenresDetailFragmentViewModelFactory
import com.example.musicwiki.viewmodels.GenresDetailFragmentViewModel
import com.example.musicwiki.viewmodels.SharedViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class GenresDetailFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentGenresDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenresDetailBinding.inflate(inflater, container, false)
        loadFragment(TracksListFragment())
        val tageName = sharedViewModel.genres.value.toString()
        val viewModel = ViewModelProvider(
            this, GenresDetailFragmentViewModelFactory(tageName)
        )[GenresDetailFragmentViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        sharedViewModel.artistsDetailTransaction.observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(R.id.action_genresDetailFragment_to_artistDetailFragment)
            }
        }

        sharedViewModel.albumDetailTransaction.observe(viewLifecycleOwner){
            if(it){
                findNavController().navigate(R.id.action_genresDetailFragment_to_albumDetailFragment)
            }
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.tracksListFragment -> {loadFragment(TracksListFragment()) ; true}
                R.id.artistsListFragment -> {loadFragment(ArtistsListFragment()) ; true}
                R.id.albumsListFragment -> {loadFragment(AlbumsListFragment()) ; true}
                else -> {loadFragment(AlbumsListFragment()) ; true}
            }
        }

        return binding.root
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout,fragment)
        transaction.commit()
    }

}