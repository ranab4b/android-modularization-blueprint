package com.ranab4b.modularization.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ranab4b.modularization.core.common.theme.ThemeMode
import com.ranab4b.modularization.core.ui.components.BlueprintTopBar

@Composable
fun SettingsScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
) {
    val themeMode by viewModel.themeMode.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { BlueprintTopBar(title = "Settings", onBack = onBack) },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
            Text(text = "App theme", style = MaterialTheme.typography.titleLarge)

            ThemeMode.entries.forEach { mode ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = mode == themeMode,
                            onClick = { viewModel.onThemeModeSelected(mode) },
                        )
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    RadioButton(selected = mode == themeMode, onClick = { viewModel.onThemeModeSelected(mode) })
                    Text(text = mode.name.lowercase().replaceFirstChar { it.uppercase() })
                }
            }
        }
    }
}
