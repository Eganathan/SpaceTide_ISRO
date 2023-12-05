package dev.eknath.spacetide_isro.data.sources.remote

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import dev.eknath.spacetide_isro.data.sources.remote.util.MissionStatus

class MissionStatusAdapter {
    @ToJson
    fun toJson(card: MissionStatus): String {
        return card.name.replace("_", " ")
    }

    @FromJson
    fun fromJson(missionStatus: String): MissionStatus {
        return MissionStatus.valueOf(missionStatus.replace(" ", "_"))
    }
}