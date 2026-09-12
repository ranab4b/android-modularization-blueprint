package com.ranab4b.modularization.core.common.di

import com.ranab4b.modularization.core.common.repository.FakeItemRepository
import com.ranab4b.modularization.core.common.repository.ItemRepository
import com.ranab4b.modularization.core.common.theme.InMemoryThemeRepository
import com.ranab4b.modularization.core.common.theme.ThemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonModule {

    @Binds
    abstract fun bindItemRepository(impl: FakeItemRepository): ItemRepository

    @Binds
    abstract fun bindThemeRepository(impl: InMemoryThemeRepository): ThemeRepository
}
