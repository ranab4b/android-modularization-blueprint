package com.ranab4b.modularization.feature.settings

import androidx.lifecycle.ViewModel
import com.ranab4b.modularization.core.common.theme.ThemeMode
import com.ranab4b.modularization.core.common.theme.ThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeRepository: ThemeRepository,
) : ViewModel() {

    val themeMode: StateFlow<ThemeMode> = themeRepository.themeMode

    fun onThemeModeSelected(mode: ThemeMode) {
        themeRepository.setThemeMode(mode)
    }
}
