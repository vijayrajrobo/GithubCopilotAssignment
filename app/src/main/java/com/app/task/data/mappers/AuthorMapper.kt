package com.app.task.data.mappers

import com.app.task.data.entities.AuthorEntity
import com.app.task.domain.models.Author
import javax.inject.Inject

class AuthorMapper @Inject constructor() {
    // AuthorMapper class is used to map the  Author to AuthorEntity
    fun mapToDomain(authorEntity: AuthorEntity): Author {
        return Author(
            authorId = authorEntity.authorId,
            authorImage = authorEntity.authorImage,
            authorName = authorEntity.authorName
        )
    }
}
