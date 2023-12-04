package com.geek.app.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.app.data.DataArticles
import com.geek.app.model.Article

class ArticleViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    init {
        _articles.value = DataArticles.articles
    }

    fun searchArticles(query: String) {
        _articles.value = _articles.value?.filter {
            it.title.toString().contains(query, ignoreCase = true)
        }
    }

    fun resetSearch() {
        _articles.value = DataArticles.articles
    }
}