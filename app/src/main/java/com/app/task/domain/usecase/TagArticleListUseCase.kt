package com.app.task.domain.usecase

import com.app.task.domain.models.Article
import com.app.task.domain.repository.ArticleRepository

class TagArticleListUseCase(private val repository: ArticleRepository) {
    fun execute(tagId: String): List<Article> {
        return repository.tagArticleList(tagId)
    }
}
