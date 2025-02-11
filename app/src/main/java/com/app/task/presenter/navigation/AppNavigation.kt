package com.app.task.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.task.domain.models.Article
import com.app.task.presenter.features.details.DetailsScreen
import com.app.task.presenter.features.home.HomeScreen
import com.app.task.presenter.features.tag.TagListScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = Screen.Home.route,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Detail.route) {
            val article =
                navController.previousBackStackEntry?.savedStateHandle?.get<Article>("article")
            article?.let {
                DetailsScreen(navController = navController, article = it)
            }
        }
        composable(route = Screen.Tag.route) { backStackEntry ->
            val tagId = backStackEntry.arguments?.getString("id") ?: ""
            tagId.let {
                TagListScreen(navController = navController, tag = tagId)
            }
        }
    }
}
