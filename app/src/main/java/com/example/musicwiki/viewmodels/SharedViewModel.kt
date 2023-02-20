package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _transition = MutableLiveData<Boolean>(false)
    val transition: LiveData<Boolean> get() = _transition

    private val _artistDetailTransaction = MutableLiveData<Boolean>()
    val artistsDetailTransaction: LiveData<Boolean> get() = _artistDetailTransaction

    private val _albumDetailTransaction = MutableLiveData<Boolean>()
    val albumDetailTransaction: LiveData<Boolean> get() = _albumDetailTransaction

    private val _genres = MutableLiveData<String>()
    val genres: LiveData<String> = _genres

    private val _artistName = MutableLiveData<String>()
    val artistName: LiveData<String> = _artistName

    private val _albumName = MutableLiveData<String>()
    val albumName: LiveData<String> = _albumName


    fun onGenresClick(tag: String) {
        _genres.value = tag
        _transition.value = true
        _transition.value = false
    }

    fun onArtistClick(artistName: String) {
        _artistName.value = artistName
        _artistDetailTransaction.value = true
        _artistDetailTransaction.value = false
    }

    fun onAlbumClick(albumName: String, artistName: String) {
        _artistName.value = artistName
        _albumName.value = albumName
        _albumDetailTransaction.value = true
        _albumDetailTransaction.value = false
    }

}