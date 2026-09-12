package com.ranab4b.modularization.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ranab4b.modularization.core.common.model.Item
import com.ranab4b.modularization.core.common.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

const val ITEM_ID_ARG = "itemId"

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    itemRepository: ItemRepository,
) : ViewModel() {

    val item: Item? = savedStateHandle.get<String>(ITEM_ID_ARG)?.let { itemRepository.getItemById(it) }
}
