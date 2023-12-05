package dev.eknath.spacetide_isro.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.eknath.spacetide_isro.data.sources.remote.MissionStatusAdapter
import dev.eknath.spacetide_isro.data.sources.remote.api.SpaceCraftService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val BASE_URL = "https://services.isrostats.in/api/"

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).add(MissionStatusAdapter()).build()
    }

    @Provides
    fun providesRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    @Provides
    fun provideSpacecraftApi(retrofit: Retrofit): SpaceCraftService =
        retrofit.create(SpaceCraftService::class.java)
}