package com.app.task.data.repository

import com.app.task.data.datasource.LocalDataSource
import com.app.task.data.mappers.ArticleMapper
import com.app.task.domain.models.Article
import com.app.task.domain.models.Author
import com.app.task.domain.models.Category
import com.app.task.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val articleMapper: ArticleMapper
) : ArticleRepository {

    override fun articleDetail(articleId: String): Article? {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response.firstOrNull { it.articleId == articleId }
    }

    override fun loadArticles(): List<Article> {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response
    }

    override fun tagArticleList(tagId: String): List<Article> {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response.filter { it.tags.contains(tagId) }
    }

    override fun authorList(): List<Author> {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response.map { it.author }.distinct()
    }

    override fun categoryList(): List<Category> {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response.map { it.category }.distinct()
    }

    override fun tagList(): List<String> {
        val response = localDataSource.getHomePageData().map { articleMapper.mapToDomain(it) }
        return response.flatMap { it.tags }.distinct()
    }
}
