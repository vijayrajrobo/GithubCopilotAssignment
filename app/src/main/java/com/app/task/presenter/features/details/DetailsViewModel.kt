package com.app.task.presenter.features.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.task.domain.models.Article
import com.app.task.domain.usecase.ArticleDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val articleDetailUseCase: ArticleDetailUseCase) :
    ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> get() = _article

    fun fetchArticleDetail(article: Article) {
        viewModelScope.launch {
            _article.value = article
            val data = articleDetailUseCase.execute(article.articleId)
            _article.value = data ?: article
        }
    }
}
