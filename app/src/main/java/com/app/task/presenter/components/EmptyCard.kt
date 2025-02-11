package com.app.task.presenter.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EmptyCard(modifier: Modifier = Modifier) {
    // Show a message when no articles are found
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "No results found.",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.Center),
        )
    }
}
