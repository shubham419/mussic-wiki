package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.models.albumdetail.AlbumDetail
import com.example.musicwiki.models.genres.TopGenresList
import com.example.musicwiki.repository.GenresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumDetailFragmentViewModel(artistName: String, albumName: String) : ViewModel() {
    private var genresService: GenresService =
        RetrofitHelper.getInstance().create(GenresService::class.java)
    private val repository: GenresRepository = GenresRepository(genresService)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAlbumDetail(artistName = artistName, albumName = albumName)
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getGenres()
        }
    }

    val album: LiveData<AlbumDetail>
        get() = repository.albumDetail

    val genres: LiveData<TopGenresList>
        get() = repository.genres

}