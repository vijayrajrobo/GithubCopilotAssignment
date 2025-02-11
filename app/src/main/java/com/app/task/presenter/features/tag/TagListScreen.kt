package com.app.task.presenter.features.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.task.presenter.components.ArtistCard
import com.app.task.presenter.components.CustomAppBar
import com.app.task.presenter.navigation.Screen

@Composable
fun TagListScreen(
    viewModel: TagListViewModel = hiltViewModel(),
    navController: NavHostController,
    tag: String,
) {
    viewModel.fetchTagArticles(tag)
    val articles = viewModel.articles.value
    Scaffold(
        topBar = {
            CustomAppBar(tag) {
                navController.navigateUp()
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            articles?.let {
                items(it) { article ->
                    ArtistCard(
                        title = article.title,
                        subTitle = article.subtitle,
                        image = article.hero
                    ) {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "article",
                            article
                        )
                        navController.navigate(Screen.Detail.route)
                    }
                }
            }
        }
    }
}
