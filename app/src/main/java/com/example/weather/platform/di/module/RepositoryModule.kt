package com.example.weather.platform.di.module

import com.example.weather.data.network.CoreServiceApi
import com.example.weather.data.repository.WeatherRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    fun weatherRepositoryProvider(apiService: CoreServiceApi): WeatherRepositoryImpl =
        WeatherRepositoryImpl(apiService)

}