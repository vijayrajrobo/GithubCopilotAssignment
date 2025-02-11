package com.app.task.presenter.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.task.domain.models.Author
import com.app.task.domain.models.Category

@Composable
fun FilterCard(
    authors: List<Author>,
    categories: List<Category>,
    tags: List<String>,
    onFilterSelected: (Author?, Category?, String?) -> Unit
) {
    // Use rememberSaveable to retain state during configuration changes
    var selectedAuthor by rememberSaveable { mutableStateOf<Author?>(null) }
    var selectedCategory by rememberSaveable { mutableStateOf<Category?>(null) }
    var selectedTag by rememberSaveable { mutableStateOf<String?>(null) }

    // Check if any filter is applied (i.e., not "All")
    val isFilterApplied = selectedAuthor != null || selectedCategory != null || selectedTag != null

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Author Dropdown
            FilterDropdown(
                label = "Author",
                options = listOf("All") + authors.map { it.authorName },
                selectedOption = selectedAuthor?.authorName ?: "All",
                onOptionSelected = {
                    selectedAuthor = authors.find { author -> author.authorName == it }
                    if (it == "All") selectedAuthor = null
                    onFilterSelected(
                        selectedAuthor,
                        selectedCategory,
                        selectedTag
                    ) // Apply filter immediately
                }
            )

            // Category Dropdown
            FilterDropdown(
                label = "Category",
                options = listOf("All") + categories.map { it.categoryName },
                selectedOption = selectedCategory?.categoryName ?: "All",
                onOptionSelected = {
                    selectedCategory = categories.find { category -> category.categoryName == it }
                    if (it == "All") selectedCategory = null
                    onFilterSelected(
                        selectedAuthor,
                        selectedCategory,
                        selectedTag
                    ) // Apply filter immediately
                }
            )

            // Tag Dropdown
            FilterDropdown(
                label = "Tag",
                options = listOf("All") + tags,
                selectedOption = selectedTag ?: "All",
                onOptionSelected = {
                    selectedTag = if (it == "All") null else it
                    onFilterSelected(
                        selectedAuthor,
                        selectedCategory,
                        selectedTag
                    ) // Apply filter immediately
                }
            )
        }

        // Show "Clear Filter" only if a filter is applied
        if (isFilterApplied) {
            Button(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                onClick = {
                    // Reset all filters to "All"
                    selectedAuthor = null
                    selectedCategory = null
                    selectedTag = null
                    onFilterSelected(null, null, null) // Apply reset filter immediately
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text("Clear Filter")
            }
        }
    }
}
