package com.app.task.presenter.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.task.domain.models.Article
import com.app.task.domain.models.Author
import com.app.task.domain.models.Category
import com.app.task.domain.usecase.AuthorListUseCase
import com.app.task.domain.usecase.CategoryListUseCase
import com.app.task.domain.usecase.GetArticleListUseCase
import com.app.task.domain.usecase.TagListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val authorListUseCase: AuthorListUseCase,
    private val categoryListUseCase: CategoryListUseCase,
    private val tagListUseCase: TagListUseCase,
) : ViewModel() {

    private val _authors = MutableLiveData<List<Author>>(emptyList())
    val authors: LiveData<List<Author>> get() = _authors

    private val _categories = MutableLiveData<List<Category>>(emptyList())
    val categories: LiveData<List<Category>> get() = _categories

    private val _tags = MutableLiveData<List<String>>(emptyList())
    val tags: LiveData<List<String>> get() = _tags

    private val _allArticles = MutableLiveData<List<Article>>(emptyList())
    val allArticles: LiveData<List<Article>> get() = _allArticles

    private val _filteredArticles = MutableLiveData<List<Article>>(emptyList())
    val filteredArticles: LiveData<List<Article>> get() = _filteredArticles

    init {
        fetchAuthors()
        fetchCategories()
        fetchTags()
        fetchArticles()
    }

    private fun fetchAuthors() {
        viewModelScope.launch {
            _authors.value = authorListUseCase.execute()
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            _categories.value = categoryListUseCase.execute()
        }
    }

    private fun fetchTags() {
        viewModelScope.launch {
            _tags.value = tagListUseCase.execute()
        }
    }

    private fun fetchArticles() {
        viewModelScope.launch {
            _allArticles.value = getArticleListUseCase.execute()
            _filteredArticles.value = allArticles.value
        }
    }

    fun filterArticles(author: Author?, category: Category?, tag: String?) {
        _filteredArticles.value = allArticles.value?.filter {
            (author == null || it.author == author) &&
                    (category == null || it.category == category) &&
                    (tag == null || it.tags.contains(tag))
        }
    }

    // Refresh the articles
    fun refreshArticles() {
        viewModelScope.launch {
            // Reload data
            fetchArticles()
        }
    }
}
