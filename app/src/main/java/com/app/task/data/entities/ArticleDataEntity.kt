package com.app.task.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ArticleDataEntity(
    val articles: List<ArticleEntity>
)
