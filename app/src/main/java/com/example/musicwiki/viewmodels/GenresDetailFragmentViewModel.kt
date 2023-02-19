package com.example.musicwiki.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicwiki.api.GenresService
import com.example.musicwiki.api.RetrofitHelper
import com.example.musicwiki.models.genresdetail.GenresDetail
import com.example.musicwiki.repository.GenresRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenresDetailFragmentViewModel( private val tagName: String) : ViewModel() {
    private var genresService: GenresService = RetrofitHelper.getInstance().create(GenresService::class.java)
    private val repository: GenresRepository = GenresRepository(genresService)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getGenresDetail(tagName)
        }
    }

    var genresTitle = MutableLiveData<String>("initial")



    val genresDetail: LiveData<GenresDetail>
        get() = repository.genresDetail

    fun dataChanged(){
        genresTitle.value =" genresDetail.value?.tag?.name"
    }

}