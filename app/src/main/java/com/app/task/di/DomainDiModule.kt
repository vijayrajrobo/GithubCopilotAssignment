package com.app.task.di

import com.app.task.domain.repository.ArticleRepository
import com.app.task.domain.usecase.ArticleDetailUseCase
import com.app.task.domain.usecase.AuthorListUseCase
import com.app.task.domain.usecase.CategoryListUseCase
import com.app.task.domain.usecase.GetArticleListUseCase
import com.app.task.domain.usecase.TagArticleListUseCase
import com.app.task.domain.usecase.TagListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainDiModule {
    @Provides
    fun provideArticleDetailUseCase(repository: ArticleRepository): ArticleDetailUseCase {
        return ArticleDetailUseCase(repository)
    }

    @Provides
    fun provideGetArticleListUseCase(repository: ArticleRepository): GetArticleListUseCase {
        return GetArticleListUseCase(repository)
    }

    @Provides
    fun provideTagArticleListUseCase(repository: ArticleRepository): TagArticleListUseCase {
        return TagArticleListUseCase(repository)
    }

    @Provides
    fun provideAuthorListUseCase(repository: ArticleRepository): AuthorListUseCase {
        return AuthorListUseCase(repository)
    }

    @Provides
    fun provideCategoryListUseCase(repository: ArticleRepository): CategoryListUseCase {
        return CategoryListUseCase(repository)
    }

    @Provides
    fun provideTagListUseCase(repository: ArticleRepository): TagListUseCase {
        return TagListUseCase(repository)
    }
}
