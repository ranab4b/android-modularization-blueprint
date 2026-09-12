package com.ranab4b.modularization.feature.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.hilt.navigation.compose.hiltViewModel
import com.ranab4b.modularization.core.ui.components.BlueprintItemCard
import com.ranab4b.modularization.core.ui.components.BlueprintTopBar
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp

/**
 * app's NavHost is the only place that knows this screen exists on a "home" route -
 * feature-home itself has no idea about navigation graphs, only these two callbacks.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onItemClick: (String) -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val items by viewModel.items.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            BlueprintTopBar(
                title = "Home",
                actions = {
                    IconButton(onClick = onSettingsClick) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
                    }
                },
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(items, key = { it.id }) { item ->
                BlueprintItemCard(
                    title = item.title,
                    subtitle = item.subtitle,
                    onClick = { onItemClick(item.id) },
                )
            }
        }
    }
}
