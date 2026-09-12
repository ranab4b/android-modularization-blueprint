package com.ranab4b.modularization.feature.home

import androidx.lifecycle.ViewModel
import com.ranab4b.modularization.core.common.model.Item
import com.ranab4b.modularization.core.common.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    itemRepository: ItemRepository,
) : ViewModel() {

    val items: StateFlow<List<Item>> = itemRepository.items
}
