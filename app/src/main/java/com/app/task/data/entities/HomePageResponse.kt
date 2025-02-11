package com.app.task.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class HomePageResponse(
    val status: Int,
    val message: String,
    val data: ArticleDataEntity
)
