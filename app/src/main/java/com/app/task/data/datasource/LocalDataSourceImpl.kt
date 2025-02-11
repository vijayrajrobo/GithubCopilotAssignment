package com.app.task.data.datasource

import android.content.Context
import com.app.task.common.extensions.readJsonFromAssets
import com.app.task.data.entities.ArticleEntity
import com.app.task.data.entities.HomePageResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val context: Context) : LocalDataSource {
    override fun getHomePageData(): List<ArticleEntity> {
        return try {
            val jsonString = context.readJsonFromAssets("homePage.json") ?: return emptyList()
            val responseType = object : TypeToken<HomePageResponse>() {}.type
            val response: HomePageResponse = Gson().fromJson(jsonString, responseType)
            response.data.articles
        } catch (e: IOException) {
            e.printStackTrace()
            emptyList()
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}
