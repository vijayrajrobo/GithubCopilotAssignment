package com.app.task.domain.usecase

import com.app.task.domain.models.Article
import com.app.task.domain.repository.ArticleRepository


class ArticleDetailUseCase(private val repository: ArticleRepository) {
    fun execute(articleId: String): Article? {
        return repository.articleDetail(articleId)
    }
}
