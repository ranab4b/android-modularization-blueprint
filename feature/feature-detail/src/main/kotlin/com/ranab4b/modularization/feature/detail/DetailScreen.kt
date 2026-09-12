package com.ranab4b.modularization.feature.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ranab4b.modularization.core.ui.components.BlueprintTopBar

@Composable
fun DetailScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val item = viewModel.item

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { BlueprintTopBar(title = item?.title ?: "Detail", onBack = onBack) },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            if (item != null) {
                Text(text = item.subtitle, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = item.description, style = MaterialTheme.typography.bodyLarge)
            } else {
                Text(text = "Item not found", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
