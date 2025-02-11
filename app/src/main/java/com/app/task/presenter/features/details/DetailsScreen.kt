package com.app.task.presenter.features.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.task.domain.models.Article
import com.app.task.presenter.components.CustomAppBar
import com.app.task.presenter.components.DetailCard
import com.app.task.presenter.navigation.Screen

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navController: NavHostController,
    article: Article,
) {
    viewModel.fetchArticleDetail(article)
    val articleDetail = viewModel.article.value
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CustomAppBar("Details") {
                navController.navigateUp()
            }
        }
    ) { innerPadding ->
        articleDetail?.let {
            DetailCard(
                modifier = Modifier.padding(innerPadding),
                article = it
            ) { tag ->
                navController.navigate(Screen.Tag.createRoute(tag))
            }
        }
    }
}
