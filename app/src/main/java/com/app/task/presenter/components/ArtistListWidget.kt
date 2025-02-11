package com.app.task.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.task.domain.models.Article
import com.app.task.presenter.navigation.Screen

@Composable
fun ArtistListWidget(articles: List<Article>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        items(articles) { article ->
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
