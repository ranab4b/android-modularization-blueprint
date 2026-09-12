package com.ranab4b.modularization.core.common.theme

import kotlinx.coroutines.flow.StateFlow

/**
 * Single source of truth for the app's theme. feature-settings writes to it, app reads
 * from it to drive the top-level MaterialTheme - both go through this shared singleton.
 */
interface ThemeRepository {
    val themeMode: StateFlow<ThemeMode>
    fun setThemeMode(mode: ThemeMode)
}
