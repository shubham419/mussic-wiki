package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _visibility = MutableLiveData<Boolean>(true)
    val visibility: LiveData<Boolean> get() = _visibility



}