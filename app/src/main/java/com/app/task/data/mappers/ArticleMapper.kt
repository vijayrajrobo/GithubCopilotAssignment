package com.app.task.data.mappers

import com.app.task.data.entities.ArticleEntity
import com.app.task.domain.models.Article
import javax.inject.Inject

class ArticleMapper @Inject constructor(
    private val authorMapper: AuthorMapper,
    private val categoryMapper: CategoryMapper
) {
    // AuthorMapper class is used to map the  Article to ArticleEntity
    fun mapToDomain(articleEntity: ArticleEntity): Article {
        return Article(
            articleId = articleEntity.articleId,
            title = articleEntity.title,
            subtitle = articleEntity.subtitle,
            hero = articleEntity.hero,
            description = articleEntity.description,
            published = articleEntity.published,
            articleType = articleEntity.articleType,
            tags = articleEntity.tags,
            author = authorMapper.mapToDomain(articleEntity.author),
            category = categoryMapper.mapToDomain(articleEntity.category)
        )
    }
}
