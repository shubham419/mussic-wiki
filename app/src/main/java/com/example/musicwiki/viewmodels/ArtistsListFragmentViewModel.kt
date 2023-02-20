package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.models.artists.ArtistsList
import com.example.musicwiki.repository.GenresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistsListFragmentViewModel(tageName: String) : ViewModel() {
    private var genresService: GenresService =
        RetrofitHelper.getInstance().create(GenresService::class.java)
    private val repository: GenresRepository = GenresRepository(genresService)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTopArtists(tageName)
        }
    }

    val artists: LiveData<ArtistsList>
        get() = repository.topArtistsList
}