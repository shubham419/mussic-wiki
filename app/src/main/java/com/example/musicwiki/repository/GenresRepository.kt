package com.example.musicwiki.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.models.album.AlbumList
import com.example.musicwiki.models.artistdetail.ArtistDetail
import com.example.musicwiki.models.artists.ArtistsList
import com.example.musicwiki.models.artisttopalbum.ArtistTopAlbum
import com.example.musicwiki.models.artisttoptrack.ArtistTopTrack
import com.example.musicwiki.models.genres.TopGenresList
import com.example.musicwiki.models.genresdetail.GenresDetail
import com.example.musicwiki.models.track.TracksList

class GenresRepository(private val genresService: GenresService) {

    private val _genres = MutableLiveData<TopGenresList>()
    val genres: LiveData<TopGenresList> = _genres

    private val _genresDetail = MutableLiveData<GenresDetail>()
    val genresDetail: LiveData<GenresDetail> = _genresDetail

    private val _topAlbumList = MutableLiveData<AlbumList>()
    val topAlbumList: LiveData<AlbumList> = _topAlbumList

    private val _topArtistsList = MutableLiveData<ArtistsList>()
    val topArtistsList: LiveData<ArtistsList> = _topArtistsList

    private val _topTracksList = MutableLiveData<TracksList>()
    val topTracksList: LiveData<TracksList> = _topTracksList

    private val _artistTopTracksList = MutableLiveData<ArtistTopTrack>()
    val artistTopTracksList: LiveData<ArtistTopTrack> = _artistTopTracksList

    private val _artistTopAlbumList = MutableLiveData<ArtistTopAlbum>()
    val artistTopAlbumList: LiveData<ArtistTopAlbum> = _artistTopAlbumList

    private val _artistDetail = MutableLiveData<ArtistDetail>()
    val artistDetail: LiveData<ArtistDetail> = _artistDetail

    suspend fun getGenres() {
        val result = genresService.getGenres()
        if (result?.body() != null) {
            _genres.postValue(result.body())
        }
    }

    suspend fun getGenresDetail(tagName: String) {
        val result = genresService.getGenresDetail(tag = tagName)
        if (result?.body() != null) {
            _genresDetail.postValue(result.body())
        }
    }

    suspend fun getTopAlbums(tagName: String) {
        val result = genresService.getTopAlbums(tag = tagName)
        if (result?.body() != null) {
            _topAlbumList.postValue(result.body())
        }
    }

    suspend fun getTopArtists(tagName: String) {
        val result = genresService.getTopArtists(tag = tagName)
        if (result?.body() != null) {
            _topArtistsList.postValue(result.body())
        }
    }

    suspend fun getTopTracks(tagName: String){
        val result = genresService.getTopTracks(tag = tagName)
        if (result?.body() != null) {
            _topTracksList.postValue(result.body())
        }
    }

    suspend fun getArtistTopTracks(artistName: String){
        val result = genresService.getArtistTopTracks(artistName = artistName)
        if (result?.body() != null) {
            _artistTopTracksList.postValue(result.body())
        }
    }

    suspend fun getArtistTopAlbum(artistName: String){
        val result = genresService.getArtistTopAlbum(artistName = artistName)
        if (result?.body() != null) {
            _artistTopAlbumList.postValue(result.body())
        }
    }

    suspend fun getArtistDetail(artistName: String){
        val result = genresService.getArtistDetail(artistName = artistName)
        if (result?.body() != null) {
            _artistDetail.postValue(result.body())
        }
    }


}