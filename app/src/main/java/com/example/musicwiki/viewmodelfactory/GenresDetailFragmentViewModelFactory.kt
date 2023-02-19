package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.repository.GenresRepository
import com.example.musicwiki.viewmodels.GenresDetailFragmentViewModel

class GenresDetailFragmentViewModelFactory( private val tagName: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenresDetailFragmentViewModel(tagName) as T
    }
}