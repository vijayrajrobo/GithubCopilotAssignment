package com.app.task.data.mappers

import com.app.task.data.entities.CategoryEntity
import com.app.task.domain.models.Category
import javax.inject.Inject

class CategoryMapper @Inject constructor() {
    // CategoryMapper class is used to map the  Category to CategoryEntity
    fun mapToDomain(categoryEntity: CategoryEntity): Category {
        return Category(
            categoryId = categoryEntity.categoryId,
            categoryName = categoryEntity.categoryName
        )
    }
}
