package com.example.weather.platform.di.module

import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun weatherUseCaseProvider(weatherRepositoryImpl : WeatherRepositoryImpl) =
        WeatherUseCase(weatherRepositoryImpl)
}