package com.app.task.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
    val categoryId: String,
    val categoryName: String
)
