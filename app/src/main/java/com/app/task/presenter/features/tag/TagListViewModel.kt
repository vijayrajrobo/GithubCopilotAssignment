package com.app.task.presenter.features.tag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.task.domain.models.Article
import com.app.task.domain.usecase.TagArticleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagListViewModel @Inject constructor(private val tagArticleListUseCase: TagArticleListUseCase) :
    ViewModel() {

    private val _articles = MutableLiveData<List<Article>>(emptyList())
    val articles: LiveData<List<Article>> get() = _articles

    fun fetchTagArticles(tag: String) {
        viewModelScope.launch {
            _articles.value = tagArticleListUseCase.execute(tag)
        }
    }
}
