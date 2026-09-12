package com.ranab4b.modularization.core.common.repository

import com.ranab4b.modularization.core.common.model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Hardcoded in-memory data source. Intentionally has no network or database backing -
 * this template is about module structure and build times, not a real backend.
 */
@Singleton
class FakeItemRepository @Inject constructor() : ItemRepository {

    private val fakeItems = listOf(
        Item(
            id = "1",
            title = "Modular Architecture",
            subtitle = "Split by feature, not by layer",
            description = "Breaking an app into feature and core modules keeps build " +
                "graphs shallow, so touching one feature only recompiles that feature " +
                "and whatever depends on it - not the whole app.",
        ),
        Item(
            id = "2",
            title = "Gradle api vs implementation",
            subtitle = "Control what leaks across module boundaries",
            description = "Using implementation instead of api for internal dependencies " +
                "prevents downstream modules from recompiling when an internal detail " +
                "changes, which is one of the biggest levers for incremental build speed.",
        ),
        Item(
            id = "3",
            title = "Hilt Across Modules",
            subtitle = "DI without tight coupling",
            description = "Each feature module declares its own Hilt-provided ViewModel. " +
                "Shared bindings, like this fake repository, live in core-common and are " +
                "installed once in the SingletonComponent.",
        ),
        Item(
            id = "4",
            title = "Compose Navigation",
            subtitle = "Assembled once, in app",
            description = "Feature screens expose plain composables with lambda callbacks " +
                "for navigation events. Only the app module knows about routes and the " +
                "NavHost, so features stay reusable and testable in isolation.",
        ),
        Item(
            id = "5",
            title = "Build-Time as a Metric",
            subtitle = "Measure, don't guess",
            description = "The real payoff of modularization is incremental build time. " +
                "This repo ships a monolith-baseline branch with the identical app in a " +
                "single module, so the improvement can be measured, not assumed.",
        ),
        Item(
            id = "6",
            title = "Version Catalogs",
            subtitle = "One source of truth for dependencies",
            description = "gradle/libs.versions.toml centralizes every dependency and " +
                "plugin version so all eight modules in this project stay in sync without " +
                "copy-pasted version strings.",
        ),
    )

    private val _items: MutableStateFlow<List<Item>> = MutableStateFlow(fakeItems)
    override val items: StateFlow<List<Item>> = _items.asStateFlow()

    override fun getItemById(id: String): Item? = fakeItems.find { it.id == id }
}
