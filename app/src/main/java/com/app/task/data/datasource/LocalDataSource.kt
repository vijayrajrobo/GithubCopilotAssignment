package com.app.task.data.datasource

import com.app.task.data.entities.ArticleEntity

interface LocalDataSource {
    fun getHomePageData(): List<ArticleEntity>
}
