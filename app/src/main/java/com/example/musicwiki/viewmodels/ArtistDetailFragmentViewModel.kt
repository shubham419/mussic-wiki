package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.models.artistdetail.ArtistDetail
import com.example.musicwiki.models.artists.ArtistsList
import com.example.musicwiki.models.artisttoptrack.ArtistTopTrack
import com.example.musicwiki.models.track.TracksList
import com.example.musicwiki.repository.GenresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistDetailFragmentViewModel(artistName: String) : ViewModel(){
    private var genresService: GenresService = RetrofitHelper.getInstance().create(GenresService::class.java)
    private val repository: GenresRepository = GenresRepository(genresService)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getArtistDetail(artistName)
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.getArtistTopTracks(artistName)
        }
    }

    val tracks: LiveData<ArtistTopTrack>
        get() = repository.artistTopTracksList

    val artist: LiveData<ArtistDetail>
        get() = repository.artistDetail

}