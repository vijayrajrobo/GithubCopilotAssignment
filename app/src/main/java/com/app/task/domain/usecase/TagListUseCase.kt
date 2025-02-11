package com.app.task.domain.usecase

import com.app.task.domain.repository.ArticleRepository

class TagListUseCase(private val repository: ArticleRepository) {
    fun execute(): List<String> {
        return repository.tagList()
    }
}
