package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.viewmodels.AlbumDetailFragmentViewModel
import com.example.musicwiki.viewmodels.ArtistDetailFragmentViewModel

class AlbumDetailFragmentViewModelFactory(private val artistName: String, private val albumName:String, private val imageUrl: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumDetailFragmentViewModel(artistName, albumName, imageUrl) as T
    }
}