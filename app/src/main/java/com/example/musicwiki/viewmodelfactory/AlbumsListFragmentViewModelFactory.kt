package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.viewmodels.AlbumsListFragmentViewModel

class AlbumsListFragmentViewModelFactory(private val tagName: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumsListFragmentViewModel(tagName) as T
    }
}