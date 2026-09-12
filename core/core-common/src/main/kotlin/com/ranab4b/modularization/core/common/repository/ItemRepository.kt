package com.ranab4b.modularization.core.common.repository

import com.ranab4b.modularization.core.common.model.Item
import kotlinx.coroutines.flow.StateFlow

/**
 * Feature modules depend on this interface, never on [FakeItemRepository] directly,
 * so the in-memory data source can be swapped for a real one without touching feature code.
 */
interface ItemRepository {
    val items: StateFlow<List<Item>>
    fun getItemById(id: String): Item?
}
