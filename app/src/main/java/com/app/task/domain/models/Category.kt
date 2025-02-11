package com.app.task.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val categoryId: String,
    val categoryName: String
) : Parcelable
