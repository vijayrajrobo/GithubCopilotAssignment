package com.app.task.domain.repository

import com.app.task.domain.models.Article
import com.app.task.domain.models.Author
import com.app.task.domain.models.Category

interface ArticleRepository {
    fun articleDetail(articleId: String): Article?
    fun loadArticles(): List<Article>
    fun tagArticleList(tagId: String): List<Article>
    fun authorList(): List<Author>
    fun categoryList(): List<Category>
    fun tagList(): List<String>
}
