package com.ranab4b.modularization.core.network

import retrofit2.http.GET

/**
 * Not called anywhere in the app - the demo runs entirely off the in-memory fake
 * repository in core-common. This module exists to show where a real network layer
 * would slot into the module graph without disturbing feature or core-common code.
 */
interface ApiService {
    @GET("items")
    suspend fun getItems(): List<ItemDto>
}

data class ItemDto(
    val id: String,
    val title: String,
    val subtitle: String,
    val description: String,
)
