package com.app.task.domain.usecase

import com.app.task.domain.models.Article
import com.app.task.domain.repository.ArticleRepository

class GetArticleListUseCase(private val repository: ArticleRepository) {
    fun execute(): List<Article> {
        return repository.loadArticles()
    }
}
