package com.app.task.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ArticleEntity(
    val title: String,
    val subtitle: String,
    val hero: String,
    val description: String,
    val articleId: String,
    val published: String,
    val category: CategoryEntity,
    val author: AuthorEntity,
    val articleType: Int,
    val tags: List<String>
)
