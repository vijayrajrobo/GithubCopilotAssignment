package com.app.task.di

import android.content.Context
import com.app.task.data.datasource.LocalDataSource
import com.app.task.data.datasource.LocalDataSourceImpl
import com.app.task.data.mappers.ArticleMapper
import com.app.task.data.repository.ArticleRepositoryImpl
import com.app.task.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataDiModule {

    @Singleton
    @Provides
    fun provideArticleRepository(
        localDataSource: LocalDataSource,
        articleMapper: ArticleMapper
    ): ArticleRepository {
        return ArticleRepositoryImpl(
            localDataSource = localDataSource,
            articleMapper = articleMapper,
        )
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(
        @ApplicationContext context: Context,
    ): LocalDataSource {
        return LocalDataSourceImpl(
            context = context,
        )
    }
}
