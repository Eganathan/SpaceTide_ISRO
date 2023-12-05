package dev.eknath.spacetide_isro.domain.repository

import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import retrofit2.Response

interface SpacecraftRepository {
    suspend fun getSpaceCraftList(): Response<List<SpacecraftEntity>?>
}