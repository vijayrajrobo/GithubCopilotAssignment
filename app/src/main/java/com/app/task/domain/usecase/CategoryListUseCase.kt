package com.app.task.domain.usecase

import com.app.task.domain.models.Category
import com.app.task.domain.repository.ArticleRepository

class CategoryListUseCase(private val repository: ArticleRepository) {
    fun execute(): List<Category> {
        return repository.categoryList()
    }
}
