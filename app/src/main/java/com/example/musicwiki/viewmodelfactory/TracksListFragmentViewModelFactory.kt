package com.example.musicwiki.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.musicwiki.viewmodels.TracksListFragmentViewModel

class TracksListFragmentViewModelFactory(private val tagName: String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TracksListFragmentViewModel(tagName) as T
    }
}