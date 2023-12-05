package dev.eknath.spacetide_isro.data.repository

import dev.eknath.spacetide_isro.data.sources.remote.api.SpaceCraftService
import dev.eknath.spacetide_isro.data.sources.remote.model.SpacecraftEntity
import dev.eknath.spacetide_isro.domain.repository.SpacecraftRepository
import retrofit2.Response
import javax.inject.Inject

class SpacecraftRepositoryImpl @Inject constructor(private val service: SpaceCraftService) :
    SpacecraftRepository {
    override suspend fun getSpaceCraftList(): Response<List<SpacecraftEntity>?> {
        return service.getSpaceCrafts()
    }

}