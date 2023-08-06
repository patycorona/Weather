package com.example.weather.platform.di.component

import com.example.weather.platform.di.module.RepositoryModule
import com.example.weather.platform.di.module.RetrofitModule
import com.example.weather.platform.di.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        RetrofitModule::class,
        UseCaseModule::class
    ]
)
interface MainComponent {
}