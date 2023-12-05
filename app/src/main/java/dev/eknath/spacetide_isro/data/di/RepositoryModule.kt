package dev.eknath.spacetide_isro.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.eknath.spacetide_isro.data.repository.SpacecraftRepositoryImpl
import dev.eknath.spacetide_isro.domain.repository.SpacecraftRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsSpacecraftRepository(spacecraftRepositoryImpl: SpacecraftRepositoryImpl): SpacecraftRepository
}