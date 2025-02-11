package com.app.task.presenter.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("details")
    object Tag : Screen("tag/{id}") {
        fun createRoute(id: String) = "tag/$id"
    }
}
