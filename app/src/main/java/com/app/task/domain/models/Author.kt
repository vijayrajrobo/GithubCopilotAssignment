package com.app.task.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Author(
    val authorId: String,
    val authorImage: String?,
    val authorName: String
): Parcelable
