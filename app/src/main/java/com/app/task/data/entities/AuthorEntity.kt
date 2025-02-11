package com.app.task.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class AuthorEntity(
    val authorId: String,
    val authorImage: String?,
    val authorName: String
)
