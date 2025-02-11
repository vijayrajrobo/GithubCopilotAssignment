package com.app.task.presenter.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.app.task.presenter.components.ArtistListWidget
import com.app.task.presenter.components.EmptyCard
import com.app.task.presenter.components.FilterCard
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val articles by viewModel.filteredArticles.observeAsState(emptyList())
    val authors by viewModel.authors.observeAsState(emptyList())
    val categories by viewModel.categories.observeAsState(emptyList())
    val tags by viewModel.tags.observeAsState(emptyList())

    // Remember the state for swipe-to-refresh
    val isRefreshing = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home Screen") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing.value),
            onRefresh = {
                // Set refreshing to true before calling refresh logic
                isRefreshing.value = true
                viewModel.refreshArticles()
                // Set refreshing back to false after the data is refreshed
                isRefreshing.value = false
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
            ) {
                FilterCard(
                    authors = authors,
                    categories = categories,
                    tags = tags,
                    onFilterSelected = { author, category, tag ->
                        viewModel.filterArticles(author, category, tag)
                    }
                )
                if (articles.isEmpty()) {
                    EmptyCard(modifier = Modifier.fillMaxSize())
                } else {
                    ArtistListWidget(articles = articles, navController = navController)
                }
            }
        }
    }
}
