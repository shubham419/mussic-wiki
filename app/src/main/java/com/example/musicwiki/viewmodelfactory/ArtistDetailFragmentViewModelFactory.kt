package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.viewmodels.ArtistDetailFragmentViewModel
import com.example.musicwiki.viewmodels.ArtistsListFragmentViewModel

class ArtistDetailFragmentViewModelFactory(private val artistName: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistDetailFragmentViewModel(artistName) as T
    }
}