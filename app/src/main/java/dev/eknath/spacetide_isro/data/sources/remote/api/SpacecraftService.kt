package dev.eknath.spacetide_isro.data.sources.remote.api

import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import retrofit2.Response
import retrofit2.http.GET

interface SpaceCraftService {
    @GET("spacecraft")
    suspend fun getSpaceCrafts(): Response<List<SpacecraftEntity>?>
}