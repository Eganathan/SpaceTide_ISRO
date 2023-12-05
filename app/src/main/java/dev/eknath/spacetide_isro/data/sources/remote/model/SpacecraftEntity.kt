package dev.eknath.spacetide_isro.data.sources.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.eknath.spacetide_isro.data.sources.remote.util.MissionStatus

@JsonClass(generateAdapter = true)
data class SpacecraftEntity(
    @Json(name = "_id") val id: String,
    @Json val serialNumber: Int,
    @Json val name: String,
    @Json val launchDate: String,
    @Json val launchVehicle: String,
    @Json val orbitType: String,
    @Json val application: String,
    @Json val link: String,
    @Json val missionStatus: String//MissionStatus
)