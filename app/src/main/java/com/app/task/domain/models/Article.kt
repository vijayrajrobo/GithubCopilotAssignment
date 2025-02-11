package com.app.task.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String,
    val subtitle: String,
    val hero: String,
    val description: String,
    val articleId: String,
    val published: String,
    val category: Category,
    val author: Author,
    val articleType: Int,
    val tags: List<String>
): Parcelable
