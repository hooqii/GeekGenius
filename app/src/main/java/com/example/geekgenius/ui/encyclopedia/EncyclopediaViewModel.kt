package com.geek.app.ui.encyclopedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.app.data.DataEncyclopedia
import com.geek.app.model.Article

class EncyclopediaViewModel : ViewModel() {

    private val _encyclopedias = MutableLiveData<List<Article>>()
    val encyclopedias: LiveData<List<Article>> get() = _encyclopedias

    init {
        _encyclopedias.value = DataEncyclopedia.encyclopedia
    }

    fun searchEncyclopedias(query: String) {
        _encyclopedias.value = _encyclopedias.value?.filter {
            it.title.toString().contains(query, ignoreCase = true)
        }
    }

    fun resetSearch() {
        _encyclopedias.value = DataEncyclopedia.encyclopedia
    }
}