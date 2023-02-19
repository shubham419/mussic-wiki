package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.viewmodels.ArtistsListFragmentViewModel
import com.example.musicwiki.viewmodels.GenresDetailFragmentViewModel

class ArtistsListFragmentViewModelFactory(private val tagName: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsListFragmentViewModel(tagName) as T
    }
}