package com.app.task.domain.usecase

import com.app.task.domain.models.Author
import com.app.task.domain.repository.ArticleRepository

class AuthorListUseCase(private val repository: ArticleRepository) {
    fun execute(): List<Author> {
        return repository.authorList()
    }
}
