package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicwiki.models.genres.Tag

class SharedViewModel : ViewModel() {

    private val _transition = MutableLiveData<Boolean>(false)
    val transition: LiveData<Boolean> get() = _transition

    private val _artistDetailTransaction = MutableLiveData<Boolean>()
    val artistsDetailTransaction: LiveData<Boolean> get() = _artistDetailTransaction

    private val _genres = MutableLiveData<String>()
    val genres: LiveData<String> = _genres

    private val _artistName = MutableLiveData<String>()
    val artistName: LiveData<String> = _artistName


    fun onGenresClick(tag: String) {
        _genres.value = tag
        _transition.value = true
    }

    fun onArtistClick(artistName: String){
        _artistName.value = artistName
        _artistDetailTransaction.value = true
        _transition.value =false
    }

}