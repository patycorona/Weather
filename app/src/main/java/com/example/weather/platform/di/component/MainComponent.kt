package com.example.weather.platform.di.component

import com.example.weather.platform.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RetrofitModule::class
    ]
)
interface MainComponent {
}